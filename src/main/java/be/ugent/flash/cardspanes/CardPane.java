package be.ugent.flash.cardspanes;

import be.ugent.flash.command.ButtonHBox;
import be.ugent.flash.command.RightSidePane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CardPane extends VBox {
    protected RightSidePane rightSidePane;
    protected final ButtonHBox buttonHBox;
    protected CenterTitledPane titledPane;
    protected String topDescriptionText;
    public CardPane(){
        this.buttonHBox = new ButtonHBox();
        BorderPane.setMargin(this, new Insets(15));
        BorderPane.setAlignment(buttonHBox, Pos.BOTTOM_RIGHT);
    }

    public void fill(){
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

    public final void createTitledPane(){
        titledPane = new CenterTitledPane();
        getChildren().add(titledPane);
    }

    public void setCorrectTextField(String correctString){
    }
}