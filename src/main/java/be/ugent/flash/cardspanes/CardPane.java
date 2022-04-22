package be.ugent.flash.cardspanes;

import be.ugent.flash.command.ButtonHBox;
import be.ugent.flash.command.RightSidePane;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CardPane extends VBox {
    protected RightSidePane rightSidePane;
    protected final ButtonHBox buttonHBox;
    protected MainTitledPane titledPane;
    protected String topDescriptionText;
    public CardPane(){
        this.buttonHBox = new ButtonHBox();
        BorderPane.setAlignment(buttonHBox, Pos.BOTTOM_RIGHT);
    }

    public void fill(){
        titledPane.setLabelText(topDescriptionText);
    }

    public void setRightSidePane(RightSidePane rightSidePane){
        this.rightSidePane = rightSidePane;
        rightSidePane.changeBottomChild(null);
        getChildren().remove(titledPane);
    }

    public void addBottomButtons(){
        if(rightSidePane != null){
            rightSidePane.changeBottomChild(buttonHBox);
        }
    }

    public void createTitledPane(){
        titledPane = new MainTitledPane();
        getChildren().add(titledPane);
    }

    public void setCorrectTextField(String correctString){
    }
}