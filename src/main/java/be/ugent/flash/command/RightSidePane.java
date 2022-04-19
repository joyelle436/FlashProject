package be.ugent.flash.command;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.Map;
import java.util.Objects;

/**
 * rechterkant van de beheersinterface
 */
public class RightSidePane extends ScrollPane {

    private final BorderPane contentBorderpane;
    private final TopGridpane topGridpane;
    public RightSidePane(){
        this.topGridpane = new TopGridpane();
        this.contentBorderpane = new BorderPane();
        setMaxHeight(730);
        setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        setHbarPolicy(ScrollBarPolicy.NEVER);
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public void fillBorderpane(){
        topGridpane.fillGridpane();
        contentBorderpane.setMaxHeight(getMaxHeight());
        contentBorderpane.setTop(topGridpane);
        setContent(contentBorderpane);
    }
}