package be.ugent.flash.command;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

/**
 * Bevat {@link TopMenuItem} en staat boven de {@link MainBorderPane}
 */
public class TopMenuBar extends MenuBar {

    private final Button makeButton;
    private final Button openButton;
    public TopMenuBar(MainBorderPane mainBorderPane){
        TopMenuItem.OpenDatabase openDatabase = new TopMenuItem.OpenDatabase(mainBorderPane, "Open databank");
        TopMenuItem.MakeDatabase makeDatabase = new TopMenuItem.MakeDatabase(mainBorderPane, "Nieuw databank");
        TopMenuItem.CloseWindow closeWindow = new TopMenuItem.CloseWindow(mainBorderPane, "Sluit");
        this.openButton = openDatabase.getCorrespondingButton();
        this.makeButton = makeDatabase.getCorrespondingButton();
        MenuItem[] MENUITEMS = new TopMenuItem[]{openDatabase, makeDatabase, closeWindow};
        BorderPane.setAlignment(this, Pos.CENTER);
        /*
        Bevat alle nodige MenuItems. Staat van boven op de borderpane
         */
        Menu bestand = new Menu("Bestand");
        bestand.getItems().addAll(MENUITEMS);
        getMenus().add(bestand);
    }

    public Button getOpenButton() {
        return openButton;
    }

    public Button getMakeButton() {
        return makeButton;
    }
}
