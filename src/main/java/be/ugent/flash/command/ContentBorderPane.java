package be.ugent.flash.command;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * Staat in het midden van de rightsidepane
 */
public class ContentBorderPane extends BorderPane {

    private RightSidePane rightSidePane;
    public ContentBorderPane(RightSidePane rightSidePane){
        this.rightSidePane = rightSidePane;
        setPrefSize(rightSidePane.getMaxWidth(), rightSidePane.getMaxHeight()-15);
    }
    public void changeCenterChild(Node node){
        getChildren().remove(getCenter());
        setCenter(node);
    }

    public void changeBottomChild(Node node){
        getChildren().remove(getBottom());
        setBottom(node);
    }
}
