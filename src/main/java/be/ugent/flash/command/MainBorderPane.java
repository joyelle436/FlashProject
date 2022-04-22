package be.ugent.flash.command;

import javafx.application.Platform;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Wordt als eerst getoond als de beheersinterface
 */
public class MainBorderPane extends BorderPane {
    private MainBorderPane mainBorderPane; /* Object van dit klasse dat eerder gemaakt wordt */
    private final MenuItem[] MENUITEMS;
    private final Stage STAGE;
    private final Button makeButton;
    private final Button openButton;
    public MainBorderPane(Stage stage){
        this.STAGE = stage;
        this.openButton = new Button("Open een bestaande databank");
        this.makeButton = new Button("Maak een nieuwe databank aan");
        setId("window");
        MENUITEMS = new MenuItem[]{
                new OpenDatabase("Open databank"),
                new MakeDatabase("Maak databank aan"),
                new CloseWindow("Sluit")};
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public void makeComponents(){
        MenuBar menuBar = new MenuBar();
        BorderPane.setAlignment(menuBar, Pos.CENTER);
        /*
        Bevat alle nodige MenuItems. Staat van boven
         */
        Menu bestand = new Menu("Bestand");
        bestand.getItems().addAll(MENUITEMS);
        menuBar.getMenus().add(bestand);
        /*
        Staat in het midden met de twee knoppen erin
         */
        HBox hBox = new HBox();
        hBox.setId("startHbox");
        openButton.setOnAction(new OpenDatabase("")); /* klasse staat onderaan */
        makeButton.setOnAction(new MakeDatabase("")); /* klasse staat onderaan */
        hBox.getChildren().addAll(openButton, makeButton);
        for(Node node: hBox.getChildren()){
            node.setStyle("-fx-font-size: 13px");
        }
        setTop(menuBar);
        setCenter(hBox);
    }

    public void changeCenter(Node node){
        getChildren().remove(getCenter());
        setCenter(node);
    }

    public void setObject(MainBorderPane mainBorderPane) {
        this.mainBorderPane = mainBorderPane;
    }

    /**
     * Menu Items in eigen klassen
     */
    private class OpenDatabase extends MenuItem implements EventHandler<ActionEvent> {
        public OpenDatabase(String text){
            super(text);
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent event) {
            new DatabaseOpener(STAGE, mainBorderPane).getFile();
        }
    }
    private class MakeDatabase extends MenuItem implements EventHandler<ActionEvent> {
        public MakeDatabase(String text){
            super(text);
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            new DatabaseMaker(STAGE, mainBorderPane).makeDatabase();
        }
    }
    private static class CloseWindow extends MenuItem {
        public CloseWindow(String text){
            super(text);
            setOnAction(actionEvent -> {
                Platform.exit();
            });
        }
    }
}