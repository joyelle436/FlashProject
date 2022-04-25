package be.ugent.flash.command;

import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Wordt als eerst getoond als de beheersinterface
 */
public class MainBorderPane extends BorderPane {
    private MainBorderPane mainBorderPane; /* Object van dit klasse dat eerder gemaakt wordt */
    private final Stage STAGE;
    public MainBorderPane(Stage stage){
        this.STAGE = stage;
        setId("window");
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public void makeComponents(){
        /*
        Staat in het midden met de twee knoppen erin
         */
        TopMenuBar topMenuBar = new TopMenuBar(this);
        HBox hBox = new HBox();
        hBox.setId("startHbox");
        hBox.getChildren().addAll(topMenuBar.getOpenButton(), topMenuBar.getMakeButton());
        for(Node node: hBox.getChildren()){
            node.setStyle("-fx-font-size: 13px");
        }
        setTop(topMenuBar);
        setCenter(hBox);
    }

    public Stage getSTAGE() {
        return STAGE;
    }

    public void changeCenter(Node node){
        getChildren().remove(getCenter());
        setCenter(node);
    }

    public void setObject(MainBorderPane mainBorderPane) {
        this.mainBorderPane = mainBorderPane;
    }
}