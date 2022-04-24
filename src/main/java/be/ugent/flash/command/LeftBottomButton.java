package be.ugent.flash.command;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class LeftBottomButton extends Button implements EventHandler<ActionEvent> {

    public LeftBottomButton(){

    }
    @Override
    public void handle(ActionEvent actionEvent) {

    }
    public static class AddQuestionButton extends LeftBottomButton  {
        public AddQuestionButton(){
            setText("Vraag toevoegen");
            setStyle("-fx-font-size: 12px");
        }
        //pak the title van het vraag uit de column en geef het aan de controller
    }

    public static class DeleteQuestionButton extends LeftBottomButton {
        public DeleteQuestionButton(){
            setText("Vraag verwijderen");
            setStyle("-fx-font-size: 12px");
        }
    }
}
