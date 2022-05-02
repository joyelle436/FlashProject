package be.ugent.flash.command.rights.buttons;

import be.ugent.flash.cardspanes.CardPane;
import be.ugent.flash.command.DatabaseCollector;
import be.ugent.flash.command.DatabaseUpdater;
import be.ugent.flash.viewer.ErrorDisplay;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.SQLException;

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
        try {
            DatabaseUpdater updater = new DatabaseUpdater(cardPane.getRightSidePane().getRightController().getDatabase());

        } catch (SQLException e) {
            new ErrorDisplay().showAlert(e.getMessage());
        }

    }
}
