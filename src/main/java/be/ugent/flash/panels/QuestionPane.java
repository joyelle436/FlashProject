package be.ugent.flash.panels;

import be.ugent.flash.command.ButtonHBox;
import be.ugent.flash.command.RightSidePane;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class QuestionPane extends VBox {
    protected RightSidePane rightSidePane;
    protected final ButtonHBox buttonHBox;
    public QuestionPane(){
        this.buttonHBox = new ButtonHBox();
        BorderPane.setAlignment(buttonHBox, Pos.BOTTOM_RIGHT);
    }

    public void fill(){
    }

    public void setRightSidePane(RightSidePane rightSidePane){
        this.rightSidePane = rightSidePane;
        rightSidePane.getContentBorderpane().changeBottomChild(null);
    }

    public void addBottomButtons(){
        if(rightSidePane != null){
            rightSidePane.getContentBorderpane().changeBottomChild(buttonHBox);
        }
    }
}