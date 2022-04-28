package be.ugent.flash.command.lefts;

import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.command.QuestionData;
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

        public void addNewQuestion(String newTitle, String newType){
            CommandMapMaker mapMaker = new CommandMapMaker();
            mapMaker.makeswapedQTypeMap();
            leftSidePane.getTableView().addRow(newTitle, newType);
            leftSidePane.addQuestionToList(new QuestionData(70, newTitle, "",
                    null, mapMaker.getSwapedStringType(newType), ""));
            /* Dit ook in de databank toevoegen en ook lege List<PartData> toevoegen */
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            new AddDialogPane(this).showAndWait();
        }
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