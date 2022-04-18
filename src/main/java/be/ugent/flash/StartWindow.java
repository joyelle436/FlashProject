package be.ugent.flash;

import javafx.application.Platform;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Objects;

public class StartWindow extends BorderPane {

    private final MenuItem[] menuItems;
    private final Stage stage;
    public StartWindow(Stage stage){
        this.stage = stage;
        setId("window");
        menuItems = new MenuItem[]{
                new OpenDatabase("Open databank"),
                new MakeDatabase("Maak databank aan"),
                new CloseWindow("Sluit")};
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public void makeComponents(){
        MenuBar menuBar = new MenuBar();
        BorderPane.setAlignment(menuBar, Pos.CENTER);
        /*
        Bevat alle nodige MenuItems
         */
        Menu bestand = new Menu("Bestand");
        bestand.getItems().addAll(menuItems);
        menuBar.getMenus().add(bestand);
        /*
        Staat in het midden met de twee knoppen erin
         */
        HBox hBox = new HBox();
        hBox.setId("startHbox");
        Button firstButton = new Button("Open een bestaande databank");
        firstButton.setStyle("-fx-font-size: 15px");
        firstButton.setOnAction(new OpenDatabase("")); /* klasse staat onderaan */
        Button secondButton = new Button("Maak een nieuwe databank aan");
        secondButton.setStyle("-fx-font-size: 15px");
        secondButton.setOnAction(new MakeDatabase("")); /* klasse staat onderaan */
        hBox.getChildren().addAll(firstButton, secondButton);
        setTop(menuBar);
        setCenter(hBox);
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
            new DatabaseOpener(stage).getFile();
        }
    }
    private static class MakeDatabase extends MenuItem implements EventHandler<ActionEvent> {
        public MakeDatabase(String text){
            super(text);
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            new DatabaseMaker().makeDatabase();
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