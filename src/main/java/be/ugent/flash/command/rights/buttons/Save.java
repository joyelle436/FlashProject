package be.ugent.flash.command.rights.buttons;

import be.ugent.flash.cardspanes.CardPane;
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
        try {
            if(cardPane.updateQuestion()){
                cardPane.getRightSidePane().getRightController().getMainController().enableTableView();
                cardPane.getRightSidePane().getRightController().setLabelToCenter();
                cardPane.getRightSidePane().getRightController().getMainController().unselectInTable();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
