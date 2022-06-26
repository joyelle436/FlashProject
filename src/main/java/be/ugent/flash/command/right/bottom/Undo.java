package be.ugent.flash.command.right.bottom;

import be.ugent.flash.cardspanes.CardPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Undo extends BottomButton implements EventHandler<ActionEvent> {
    public Undo(CardPane cardPane) {
        super(cardPane);
        cardPane.getRightSidePane().getRightController().setUndo(this);
        setText("Herstellen");
        setDisable(true);
        setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        /*
         * Alle gegevens opnieuw halen uit de databank
         */
        if(cardPane.getType().charAt(0) != 'o'){
            cardPane.getTitledPane().getMainGridpane().reAddParts();
        }
        cardPane.getRightSidePane().getRightController().getRightPaneContent().
                addContents(cardPane.getQuestion(), cardPane.getQuestion().questionType());
        cardPane.getRightSidePane().getRightController().disableUndoAndSave(true);
        cardPane.getRightSidePane().getRightController().getMainController().enableTableView();
    }
}