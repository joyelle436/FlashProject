package be.ugent.flash.command.right;

import be.ugent.flash.command.right.top.TopGridpane;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.util.*;

/**
 * rechterkant van de beheersinterface
 */
public class RightSidePane extends BorderPane {

    private final TopGridpane topGridpane;
    private final RightController rightController;

    public RightSidePane(RightController rightController){
        setMaxSize(685, 715);
        this.topGridpane = new TopGridpane(rightController);
        this.rightController = rightController;
        addEventFilter(ActionEvent.ANY, event -> rightController.getMainController().disableTableView());
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public void changeCenterChild(Node node){
        getChildren().remove(getCenter());
        setCenter(node);
    }

    public void changeBottomChild(Node node){
        getChildren().remove(getBottom());
        setBottom(node);
    }

    public void setRightPaneContent(RightPaneContent rightPaneContent) {
        rightPaneContent.setRightSidePane(this);
    }

    public RightController getRightController() {
        return rightController;
    }

    public TopGridpane getTopGridpane() {
        return topGridpane;
    }

    /*
    layout van gridpane die boven staat aanmaken
     */
    public void fillRightPane(){
        getChildren().clear();
        setTop(topGridpane);
    }
}