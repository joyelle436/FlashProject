package be.ugent.flash.command;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.util.*;

/**
 * rechterkant van de beheersinterface
 */
public class RightSidePane extends BorderPane {

    private final TopGridpane topGridpane;
    private final SidePaneController controller;
    private RightPaneContent rightPaneContent;

    public RightSidePane(SidePaneController controller){
        setMaxSize(700, 730);
        this.topGridpane = new TopGridpane();
        this.controller = controller;
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
        this.rightPaneContent = rightPaneContent;
        rightPaneContent.setRightSidePane(this);
    }

    public TopGridpane getTopGridpane() {
        return topGridpane;
    }

    public void fillRightPane(){
        fillBorderpane();
    }
    /*
    layout van gridpane die boven staat aanmaken
     */
    private void fillBorderpane(){
        topGridpane.fillGridpane();
        getChildren().clear();
        topGridpane.setVisible(false);
        setTop(topGridpane);
    }
}