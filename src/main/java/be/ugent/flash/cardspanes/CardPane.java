package be.ugent.flash.cardspanes;

import be.ugent.flash.command.DatabaseUpdater;
import be.ugent.flash.command.RedPopUp;
import be.ugent.flash.command.right.*;
import be.ugent.flash.data.Question;
import javafx.geometry.*;
import javafx.scene.layout.*;

import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.util.Queue;


public class CardPane extends VBox {
    protected RightSidePane rightSidePane;
    protected ButtonHBox buttonHBox;
    protected CenterTitledPane titledPane;
    protected String topDescriptionText;
    protected String type;
    protected Question question;
    protected String correct;
    protected DatabaseUpdater databaseUpdater;

    public CardPane(String type) {
        this.type = type;
        BorderPane.setMargin(this, new Insets(15));
    }

    public void fillCardPane() {
        addBottomButtons();
    }

    public RightSidePane getRightSidePane() {
        return rightSidePane;
    }

    public void setRightSidePane(RightSidePane rightSidePane) {
        this.rightSidePane = rightSidePane;
        this.databaseUpdater = rightSidePane.getRightController().getMainController().getDatabaseUpdater();
        rightSidePane.fillRightPane();
        rightSidePane.changeBottomChild(null);
        getChildren().remove(titledPane);
    }

    private void addBottomButtons() {
        this.buttonHBox = new ButtonHBox(this);
        BorderPane.setAlignment(buttonHBox, Pos.BOTTOM_RIGHT);
        if (rightSidePane != null) {
            rightSidePane.changeBottomChild(buttonHBox);
        }
    }

    public CenterTitledPane getTitledPane() {
        return titledPane;
    }

    public final void createTitledPane() {
        titledPane = new CenterTitledPane(type, getRightSidePane().getRightController());
        getChildren().add(titledPane);
        titledPane.setLabelText(topDescriptionText);
        fillCardPane();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
        this.correct = question.correctAnswer();
    }

    /**
     * Wordt opgeroepen als er op de knop {@link be.ugent.flash.command.right.buttons.Save} geklikt wordt.
     * één checkbox aangevinkt bij een meerkeuze vraag(mcc, mcs, mci)
     */
    public boolean updateQuestion() throws SQLException {
        String[] questionTopContent = rightSidePane.getTopGridpane().getTopContent().getQuestionTopContent();
        byte[] middleImage = rightSidePane.getTopGridpane().getTopContent().getMiddleImage();
        /* De afbeelding werd niet gewijzigd */
        if (middleImage != null && middleImage.length == 0) {
            middleImage = question.middleImage();
        }
        if (questionTopContent[0].equals("") || questionTopContent[1].equals("")) {
            new RedPopUp("Titel en/of tekst is leeg");
            return false;
        }
        Question updatedQuestion = new Question(question.id(), questionTopContent[0], questionTopContent[1],
                middleImage, question.questionType(), correct);
        this.question = updatedQuestion;
        databaseUpdater.updateQuestion(updatedQuestion);
        if (!type.equals("open") && !type.equals("openi")) {
            updateParts();
        }
        return true;
    }

    private void updateParts() throws SQLException{
        Queue<AnswerChoiceObject> choiceObjectQueue = titledPane.getMainGridpane().getChoiceObjectQueue();
        if (type.equals("mci")) {
            updateImageParts(choiceObjectQueue);
            System.out.println();
        } else {
            updateStringParts(choiceObjectQueue);
        }
    }

    private void updateStringParts(Queue<AnswerChoiceObject> choiceObjectQueue) throws SQLException{
        for (AnswerChoiceObject choiceObject : choiceObjectQueue) {
            if (choiceObject.getIdPart() < Integer.MAX_VALUE) {
                databaseUpdater.updatePart(question.id(), choiceObject.getIdPart(), choiceObject.getStringPart());
            } else {
                databaseUpdater.addNewPart(question.id(), choiceObject.getStringPart());
            }
        }
    }

    private void updateImageParts(Queue<AnswerChoiceObject> choiceObjectQueue) throws SQLException {
        for (AnswerChoiceObject choiceObject : choiceObjectQueue) {
            AnswerChoiceImage choiceImage = (AnswerChoiceImage) choiceObject;
            if (choiceImage.getIdPart() < Integer.MAX_VALUE) {
                if(choiceImage.getImagePath() != null){
                    databaseUpdater.updatePart(question.id(), choiceImage.getIdPart(), choiceImage.getImagePath());
                }
            } else {
                databaseUpdater.addNewPart(question.id(), choiceImage.getImagePath());
            }
        }
    }
}