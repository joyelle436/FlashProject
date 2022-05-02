package be.ugent.flash.command.lefts;

import be.ugent.flash.CommandMapMaker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class LeftBottomButton extends Button {

    protected LeftSidePane leftSidePane; /* nodig om toegang te kunnen krijgen tot SidePaneController*/
    protected CommandMapMaker mapMaker;
    public LeftBottomButton(LeftSidePane leftSidePane){
        this.leftSidePane = leftSidePane;
        this.mapMaker = new CommandMapMaker();
        mapMaker.makeswapedQTypeMap();
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
            leftSidePane.addQuestionToDatabase(newTitle, mapMaker.getSwapedStringType(newType));
            leftSidePane.getTableView().addRow(newTitle, newType);
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
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            leftSidePane.getTableView().removeSelectedRow();
        }
    }
}