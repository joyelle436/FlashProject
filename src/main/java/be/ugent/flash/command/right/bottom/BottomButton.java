package be.ugent.flash.command.right.bottom;

import be.ugent.flash.cardspanes.CardPane;
import javafx.scene.control.Button;

public class BottomButton extends Button {

    protected CardPane cardPane;
    public BottomButton(CardPane cardPane){
        this.cardPane = cardPane;
    }
}
