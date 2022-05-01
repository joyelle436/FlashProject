package be.ugent.flash.command;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Staat in {@link be.ugent.flash.command.rights.TopGridpane}
 */
public class PictureButton extends Button implements EventHandler<ActionEvent> {
    public PictureButton(String text) {
        super(text);
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
