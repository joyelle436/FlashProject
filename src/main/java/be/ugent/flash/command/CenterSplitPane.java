package be.ugent.flash.command;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;

/**
 * Bevat Gridpane met lijst van questions aan de linkerkant + de inhoud ervan in een andere pane aan de rechterkant
 */
public class CenterSplitPane extends SplitPane {
    public CenterSplitPane(){
        setPrefSize(1200, 750);
        setOrientation(Orientation.HORIZONTAL);
        setDividerPositions(0.3);
    }
}