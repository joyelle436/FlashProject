package be.ugent.flash.command;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ClickEventSimulator {

    /* Bron: https://stackoverflow.com/questions/11552176/generating-a-mouseevent-in-javafx */
    public static void simulateClickEvent(EventTarget eventTarget){
        Event.fireEvent(eventTarget, new MouseEvent(MouseEvent.MOUSE_CLICKED, 0,
                0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true,
                true, true, true, true, true, true, null));
    }
}
