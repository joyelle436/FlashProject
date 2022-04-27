package be.ugent.flash.command.lefts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class LeftBottomButton extends Button {

    protected LeftSidePane leftSidePane; /* nodig om toegang te kunnen krijgen tot SidePaneController*/
    public LeftBottomButton(LeftSidePane leftSidePane){
        this.leftSidePane = leftSidePane;
    }

    public LeftSidePane getLeftSidePane() {
        return leftSidePane;
    }

    public static class AddQuestionButton extends LeftBottomButton implements EventHandler<ActionEvent>{
        public AddQuestionButton(LeftSidePane leftSidePane){
            super(leftSidePane);
            setText("Vraag toevoegen");
            setStyle("-fx-font-size: 12px");
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            leftSidePane.getTableView().addRow("mcs");
        }
        //dit aan leftsidepane vermelden die het vraag in de lijst toevoegt
        //pak the title van het vraag uit de column en geef het aan de controller
    }

    public static class DeleteQuestionButton extends LeftBottomButton implements EventHandler<ActionEvent> {
        public DeleteQuestionButton(LeftSidePane leftSidePane){
            super(leftSidePane);
            setText("Vraag verwijderen");
            setStyle("-fx-font-size: 12px");
        }

        @Override
        public void handle(ActionEvent actionEvent) {
        }
    }
}
