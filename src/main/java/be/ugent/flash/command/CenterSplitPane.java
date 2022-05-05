package be.ugent.flash.command;

import be.ugent.flash.command.left.LeftSidePane;
import be.ugent.flash.command.right.RightSidePane;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

/**
 * Bevat Gridpane met lijst van questions aan de linkerkant + de inhoud ervan in een andere pane aan de rechterkant
 */
public class CenterSplitPane extends SplitPane {
    public CenterSplitPane(MainBorderPane mainBorderPane, LeftSidePane leftSidePane, RightSidePane rightSidePane){
        AnchorPane.setLeftAnchor(this, 0.0);
        AnchorPane.setRightAnchor(this, 0.0);
        AnchorPane.setTopAnchor(this, 0.0);
        AnchorPane.setBottomAnchor(this, 0.0);
        setPrefSize(1200, 750);
        setOrientation(Orientation.HORIZONTAL);
        setDividerPositions(0.3);
        getItems().addAll(leftSidePane, rightSidePane);
    }
}