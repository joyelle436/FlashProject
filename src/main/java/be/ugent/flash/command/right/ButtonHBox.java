package be.ugent.flash.command.right;

import be.ugent.flash.cardspanes.CardPane;
import be.ugent.flash.command.right.buttons.*;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * staat onderaan de {@link RightSidePane} in een {@link be.ugent.flash.cardspanes.CardPane}
 */
public class ButtonHBox extends HBox {
    private final Save save;
    private final Undo undo;
    private final Preview preview;

    public ButtonHBox(CardPane cardPane){
        this.save = new Save(cardPane);
        this.undo = new Undo(cardPane);
        this.preview = new Preview(cardPane);
        setMaxSize(200, 50);
        setSpacing(7);
        BorderPane.setMargin(this, new Insets(0, 25, 15, 0));
        getChildren().addAll(save, undo, preview);
    }
}