package be.ugent.flash.command;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ButtonHBox extends HBox {
    private final Button save;
    private final Button undo;
    private final Button preview;

    public ButtonHBox(){
        this.save = new Button("Opslaan");
        this.undo = new Button("Herstellen");
        this.preview = new Button("Preview");
        setMaxSize(200, 50);
        setSpacing(7);
        BorderPane.setMargin(this, new Insets(0, 15, 0, 0));
        getChildren().addAll(save, undo, preview);
    }
}