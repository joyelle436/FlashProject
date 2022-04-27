package be.ugent.flash.command.lefts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class LeftBottomButton extends Button implements EventHandler<ActionEvent> {

    protected LeftSidePane leftSidePane; /* nodig om toegang te kunnen krijgen tot SidePaneController*/
    public LeftBottomButton(LeftSidePane leftSidePane){
        this.leftSidePane = leftSidePane;
    }

    public LeftSidePane getLeftSidePane() {
        return leftSidePane;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
    public static class AddQuestionButton extends LeftBottomButton  {
        public AddQuestionButton(LeftSidePane leftSidePane){
            super(leftSidePane);
            setText("Vraag toevoegen");
            setStyle("-fx-font-size: 12px");
        }
        //dit aan leftsidepane vermelden die het vraag in de lijst toevoegt
        //pak the title van het vraag uit de column en geef het aan de controller
    }

    public static class DeleteQuestionButton extends LeftBottomButton {
        public DeleteQuestionButton(LeftSidePane leftSidePane){
            super(leftSidePane);
            setText("Vraag verwijderen");
            setStyle("-fx-font-size: 12px");
        }
    }
}
