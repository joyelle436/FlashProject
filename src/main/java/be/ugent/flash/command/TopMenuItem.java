package be.ugent.flash.command;

import be.ugent.flash.command.databaseTools.DatabaseMaker;
import be.ugent.flash.command.databaseTools.DatabaseOpener;
import javafx.application.Platform;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;

/**
 * MenuItems die boven de {@link MainBorderPane} staan
 */
public class TopMenuItem extends MenuItem{

    protected final MainBorderPane mainBorderPane;
    protected Button correspondingButton;
    public TopMenuItem(MainBorderPane mainBorderPane, String text){
        super(text);
        this.mainBorderPane = mainBorderPane;
        this.correspondingButton = new Button();
    }

    public Button getCorrespondingButton() {
        return correspondingButton;
    }

    /**
     * Menu Items
     */
    public static class OpenDatabase extends TopMenuItem implements EventHandler<ActionEvent> {
        public OpenDatabase(MainBorderPane mainBorderPane, String text){
            super(mainBorderPane, text);
            correspondingButton.setText("Open een bestaande databank");
            correspondingButton.setOnAction(this);
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent event) {
            new DatabaseOpener(mainBorderPane).getFile();
        }
    }
    public static class MakeDatabase extends TopMenuItem implements EventHandler<ActionEvent> {
        public MakeDatabase(MainBorderPane mainBorderPane, String text){
            super(mainBorderPane, text);
            correspondingButton.setText("Maak een nieuwe databank aan");
            correspondingButton.setOnAction(this);
            setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            new DatabaseMaker(mainBorderPane).createFile();
        }
    }
    public static class CloseWindow extends TopMenuItem {
        public CloseWindow(MainBorderPane mainBorderPane, String text){
            super(mainBorderPane, text);
            setAccelerator(KeyCombination.keyCombination("Ctrl+Z"));
            setOnAction(actionEvent -> {
                Platform.exit();
            });
        }
    }
}