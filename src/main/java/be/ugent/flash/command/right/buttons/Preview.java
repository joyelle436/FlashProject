package be.ugent.flash.command.right.buttons;

import be.ugent.flash.ViewerMapMaker;
import be.ugent.flash.cardspanes.CardPane;
import be.ugent.flash.command.DatabaseCollector;
import be.ugent.flash.viewer.ErrorDisplay;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class Preview extends BottomButton implements EventHandler<MouseEvent> {
    private final ViewerMapMaker mapMaker;
    private DatabaseCollector databaseConnector;
    public Preview(CardPane cardPane) {
        super(cardPane);
        setText("Preview");
        this.mapMaker = new ViewerMapMaker();
        try {
            this.databaseConnector = new DatabaseCollector(cardPane.getRightSidePane().getRightController().getDatabase());
        } catch (SQLException e) {
            ErrorDisplay.showAlert(e.getMessage());
        }
        this.mapMaker.makeFactoryMap();
        this.mapMaker.makeVisitorMap();
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