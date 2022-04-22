package be.ugent.flash.command;

import javafx.scene.control.*;

import java.util.*;

/**
 * rechterkant van de beheersinterface
 */
public class RightSidePane extends ScrollPane {

    private final ContentBorderPane contentBorderpane;
    private final TopGridpane topGridpane;
    private final SidePaneController controller;
    public RightSidePane(SidePaneController controller){
        setMaxSize(700, 730);
        this.topGridpane = new TopGridpane();
        contentBorderpane = new ContentBorderPane(this);
        this.controller = controller;
        setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        setHbarPolicy(ScrollBarPolicy.NEVER);
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public ContentBorderPane getContentBorderpane(){
        return contentBorderpane;
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
        setContent(contentBorderpane);
        topGridpane.fillGridpane();
        contentBorderpane.getChildren().clear();
        topGridpane.setVisible(false);
        contentBorderpane.setTop(topGridpane);
    }
}