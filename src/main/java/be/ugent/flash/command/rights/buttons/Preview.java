package be.ugent.flash.command.rights.buttons;

import be.ugent.flash.ViewerMapMaker;
import be.ugent.flash.cardspanes.CardPane;
import be.ugent.flash.command.DatabaseCollector;
import be.ugent.flash.viewer.ErrorDisplay;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class Preview extends BottomButton implements EventHandler<MouseEvent> {
    private final ViewerMapMaker mapMaker = new ViewerMapMaker();
    private DatabaseCollector databaseConnector;
    public Preview(CardPane cardPane) {
        super(cardPane);
        try {
            this.databaseConnector = new DatabaseCollector(cardPane.getRightSidePane().getRightController().getDatabase());
        } catch (SQLException e) {
            new ErrorDisplay().showAlert(e.getMessage());
        }
        this.mapMaker.makeFactoryMap();
        this.mapMaker.makeVisitorMap();
        setText("Preview");
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getEventType().equals(MouseEvent.MOUSE_PRESSED)){
            // open de stage en toont de kaart

        }

        if(mouseEvent.getEventType().equals(MouseEvent.MOUSE_RELEASED)){
            //sluit de stage
        }
    }
}
