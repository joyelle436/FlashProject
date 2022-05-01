package be.ugent.flash.cardspanes;

import be.ugent.flash.command.rights.*;
import be.ugent.flash.data.Question;
import javafx.geometry.*;
import javafx.scene.layout.*;


public class CardPane extends VBox {
    protected RightSidePane rightSidePane;
    protected  ButtonHBox buttonHBox;
    protected CenterTitledPane titledPane;
    protected String topDescriptionText;
    protected String type;
    protected RightController rightController;
    protected Question question;
    public CardPane(String type){
        this.type = type;
        BorderPane.setMargin(this, new Insets(15));
    }

    public void fill(){
    }

    public RightController getRightController() {
        return rightController;
    }

    public void setRightSidePane(RightSidePane rightSidePane){
        this.rightSidePane = rightSidePane;
        /* Om toegang te krijgen tot SidePaneController*/
        this.rightController = rightSidePane.getRightController();
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
        titledPane = new CenterTitledPane(type);
        getChildren().add(titledPane);
        createPartsFiller();
        fill();
    }

    public void createPartsFiller(){
    }

    public void setCorrectTextField(String correctString){
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}