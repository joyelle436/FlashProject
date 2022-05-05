package be.ugent.flash.command.right.buttons;

import be.ugent.flash.cardspanes.CardPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Undo extends BottomButton implements EventHandler<ActionEvent> {
    public Undo(CardPane cardPane) {
        super(cardPane);
        setText("Herstellen");
        setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        /*
         * Alle gegevens opnieuw halen uit de databank en tonen
         */
        cardPane.getRightSidePane().getRightController().getRightPaneContent().
                addContents(cardPane.getQuestion(), cardPane.getQuestion().questionType());
    }
}