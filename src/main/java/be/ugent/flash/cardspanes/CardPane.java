package be.ugent.flash.cardspanes;

import be.ugent.flash.command.*;
import be.ugent.flash.command.databaseTools.DatabaseUpdater;
import be.ugent.flash.command.right.*;
import be.ugent.flash.command.right.bottom.ButtonHBox;
import be.ugent.flash.db.Question;
import javafx.geometry.*;
import javafx.scene.layout.*;

import java.sql.SQLException;


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

    public void addBottomButtons() {
        this.buttonHBox = new ButtonHBox(this);
        BorderPane.setAlignment(buttonHBox, Pos.BOTTOM_RIGHT);
        if (rightSidePane != null) {
            rightSidePane.changeBottomChild(buttonHBox);
        }
    }

    public DatabaseUpdater getDatabaseUpdater() {
        return databaseUpdater;
    }

    public CenterTitledPane getTitledPane() {
        return titledPane;
    }

    public final void createTitledPane() {
        titledPane = new CenterTitledPane(type, getRightSidePane().getRightController());
        getChildren().add(titledPane);
        titledPane.setLabelText(topDescriptionText);
        addBottomButtons();
    }

    public Question getQuestion() {
        return question;
    }

    public String getCorrect() {
        return correct;
    }

    public void setQuestion(Question question) {
        this.question = question;
        this.correct = question.correctAnswer();
        /* Dit is voor de nieuwe toegevoegde vraag */
        if(type.equals("openi") && correct.equals("")){
            correct = "0";
        }
    }

    public String getType() {
        return type;
    }

    /**
     * Wordt opgeroepen als er op de knop {@link be.ugent.flash.command.right.bottom.Save} geklikt wordt.
     */
    public boolean updateQuestion(boolean preview) throws SQLException {
        CardUpdater cardUpdater = new CardUpdater(this);
        String[] questionTopContent = rightSidePane.getTopGridpane().getTopContent().getQuestionTopContent();
        if (questionTopContent[0].equals("") || questionTopContent[1].equals("")) {
            new RedPopUp("Titel en/of tekst is leeg");
            return false;
        }
        setQuestion(cardUpdater.getUpdatedQuestion(false));
        databaseUpdater.updateQuestion(question);
        return true;
    }
}