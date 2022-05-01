package be.ugent.flash.command.rights.buttons;

import be.ugent.flash.cardspanes.CardPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Save extends BottomButton implements EventHandler<ActionEvent> {
    public Save(CardPane cardPane){
        super(cardPane);
        setText("Opslaan");
        setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        cardPane.getRightSidePane().getRightController().getMainController().enableTableView();
        cardPane.getRightSidePane().getRightController().setLabelToCenter();
        cardPane.getRightSidePane().getRightController().getMainController().unselectInTable();
    }
}
