package be.ugent.flash.cardspanes;

import be.ugent.flash.command.DatabaseUpdater;
import be.ugent.flash.command.RedPopUp;
import be.ugent.flash.command.rights.*;
import be.ugent.flash.data.Question;
import javafx.geometry.*;
import javafx.scene.layout.*;

import java.sql.SQLException;


public class CardPane extends VBox {
    protected RightSidePane rightSidePane;
    protected  ButtonHBox buttonHBox;
    protected CenterTitledPane titledPane;
    protected String topDescriptionText;
    protected String type;
    protected Question question;
    protected String correct;
    protected DatabaseUpdater databaseUpdater;
    public CardPane(String type){
        this.type = type;
        BorderPane.setMargin(this, new Insets(15));
    }

    public void fillCardPane(){
        addBottomButtons();
    }

    public RightSidePane getRightSidePane() {
        return rightSidePane;
    }

    public void setRightSidePane(RightSidePane rightSidePane){
        this.rightSidePane = rightSidePane;
        this.databaseUpdater = rightSidePane.getRightController().getMainController().getDatabaseUpdater();
        rightSidePane.fillRightPane();
        rightSidePane.changeBottomChild(null);
        getChildren().remove(titledPane);
    }

    private void addBottomButtons(){
        this.buttonHBox = new ButtonHBox(this);
        BorderPane.setAlignment(buttonHBox, Pos.BOTTOM_RIGHT);
        if(rightSidePane != null){
            rightSidePane.changeBottomChild(buttonHBox);
        }
    }

    public CenterTitledPane getTitledPane() {
        return titledPane;
    }

    public final void createTitledPane(){
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
        this.correct = "";
    }

    /**
     * Wordt opgeroepen als er op de knop {@link be.ugent.flash.command.rights.buttons.Save} geklikt wordt.
     * één checkbox aangevinkt bij een meerkeuze vraag(mcc, mcs, mci)
     */
    public boolean updateQuestion() throws SQLException {
        String[] questionTopContent = rightSidePane.getTopGridpane().getTopContent().getQuestionTopContent();
        byte[] middleImage = rightSidePane.getTopGridpane().getTopContent().getMiddleImage();
        /* De afbeelding werd niet gewijzigd */
        if(middleImage == null){
            middleImage = question.middleImage();
        }
        if(questionTopContent[0].equals("") || questionTopContent[1].equals("")){
            new RedPopUp("Titel en/of tekst is leeg");
            return false;
        }
        Question updatedQuestion = new Question(question.id(), questionTopContent[0], questionTopContent[1],
                middleImage, question.questionType(), correct);
        databaseUpdater.updateQuestion(updatedQuestion);
        return true;
    }

    public void updateParts(){
    }
}