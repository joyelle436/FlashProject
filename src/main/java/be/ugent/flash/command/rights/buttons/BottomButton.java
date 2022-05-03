package be.ugent.flash.command.rights.buttons;

import be.ugent.flash.cardspanes.CardPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BottomButton extends Button {

    protected CardPane cardPane;
    public BottomButton(CardPane cardPane){
        this.cardPane = cardPane;
    }
}
