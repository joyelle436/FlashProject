package be.ugent.flash.command;

import be.ugent.flash.command.left.LeftSidePane;
import be.ugent.flash.command.right.RightSidePane;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;

/**
 * Bevat Gridpane met lijst van questions aan de linkerkant + de inhoud ervan in een andere pane aan de rechterkant
 */
public class CenterSplitPane extends SplitPane {
    public CenterSplitPane(MainBorderPane mainBorderPane, LeftSidePane leftSidePane, RightSidePane rightSidePane){
        setPrefSize(1200, 750);
        setOrientation(Orientation.HORIZONTAL);
        setDividerPositions(0.3);
        getItems().addAll(leftSidePane, rightSidePane);
    }
}