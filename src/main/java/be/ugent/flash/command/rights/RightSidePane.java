package be.ugent.flash.command.rights;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.util.*;

/**
 * rechterkant van de beheersinterface
 */
public class RightSidePane extends BorderPane {

    private final TopGridpane topGridpane;
    private final RightController rightController;
    private RightPaneContent rightPaneContent;

    public RightSidePane(RightController rightController){
        setMaxSize(700, 730);
        this.topGridpane = new TopGridpane();
        this.rightController = rightController;
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

    public RightController getRightController() {
        return rightController;
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
        getChildren().clear();
        topGridpane.setVisible(false);
        setTop(topGridpane);
    }
}