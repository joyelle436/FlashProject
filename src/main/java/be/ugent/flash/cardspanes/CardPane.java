package be.ugent.flash.cardspanes;

import be.ugent.flash.command.DatabaseUpdater;
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
    protected DatabaseUpdater databaseUpdater;
    public CardPane(String type){
        this.type = type;
        BorderPane.setMargin(this, new Insets(15));
    }

    public void fill(){
    }

    public RightSidePane getRightSidePane() {
        return rightSidePane;
    }

    public void setRightSidePane(RightSidePane rightSidePane){
        this.rightSidePane = rightSidePane;
        this.databaseUpdater = rightSidePane.getRightController().getMainController().getDatabaseUpdater();
        rightSidePane.fillRightPane();
        /* Om toegang te krijgen tot SidePaneController*/
        rightSidePane.changeBottomChild(null);
        getChildren().remove(titledPane);
    }

    public void addBottomButtons(){
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
        fill();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * Wordt opgeroepen als er op de knop {@link be.ugent.flash.command.rights.buttons.Save} geklikt wordt
     */
    public boolean updateQuestion() throws SQLException {
        return true;
    }
}