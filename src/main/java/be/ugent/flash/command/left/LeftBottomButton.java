package be.ugent.flash.command.left;

import be.ugent.flash.command.CommandMapMaker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class LeftBottomButton extends Button {

    protected LeftSidePane leftSidePane; /* nodig om toegang te kunnen krijgen tot SidePaneController*/
    protected CommandMapMaker commandMapMaker;
    public LeftBottomButton(LeftSidePane leftSidePane){
        this.leftSidePane = leftSidePane;
        this.commandMapMaker = new CommandMapMaker();
        commandMapMaker.makeswapedQTypeMap();
    }

    public static class AddQuestionButton extends LeftBottomButton implements EventHandler<ActionEvent>{
        public AddQuestionButton(LeftSidePane leftSidePane){
            super(leftSidePane);
            setText("Vraag toevoegen");
            setFont(new Font(12));
            setOnAction(this);
        }

        public void addNewQuestion(String newTitle, String newType){
            leftSidePane.addQuestionToDatabase(newTitle, commandMapMaker.getSwapedStringType(newType));
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
            setFont(new Font(12));
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            leftSidePane.getTableView().removeSelectedRow();
        }
    }
}