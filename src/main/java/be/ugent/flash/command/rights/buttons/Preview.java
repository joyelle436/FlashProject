package be.ugent.flash.command.rights.buttons;

import be.ugent.flash.cardspanes.CardPane;
import javafx.event.ActionEvent;

public class Preview extends BottomButton {
    public Preview(CardPane cardPane) {
        super(cardPane);
        setText("Preview");
        setOnMousePressed(mouseEvent -> {
            /* Thread,.. nodig om twee programmas tegelijk te runnen */
            System.out.println("pressed");
        });

        setOnMouseReleased(mouseEvent -> {
            System.out.println("released");
        });
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
    }
}
