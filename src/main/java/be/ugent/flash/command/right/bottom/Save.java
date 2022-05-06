package be.ugent.flash.command.right.bottom;

import be.ugent.flash.cardspanes.CardPane;
import be.ugent.flash.viewer.ErrorDisplay;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.SQLException;


public class Save extends BottomButton implements EventHandler<ActionEvent> {
    public Save(CardPane cardPane){
        super(cardPane);
        cardPane.getRightSidePane().getRightController().setSave(this);
        setText("Opslaan");
        setDisable(true);
        setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            if(cardPane.updateQuestion(false)){
                cardPane.getRightSidePane().getRightController().getMainController().updateTableView(cardPane.getQuestion().title());
                cardPane.getRightSidePane().getRightController().getMainController().enableTableView();
                cardPane.getRightSidePane().getRightController().setLabelToCenter();
                cardPane.getRightSidePane().getRightController().getMainController().unselectInTable();
            }
        } catch (SQLException e) {
            ErrorDisplay.showAlert("Probleem met het updaten van de databank: " + e.getMessage());
        }
    }
}