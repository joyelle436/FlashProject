package be.ugent.flash.cardspanes;

/**
 * mcc
 */

import be.ugent.flash.command.RightSidePane;

public class CompactCardPane extends CardPane {
    public CompactCardPane(){
        this.topDescriptionText = "Er zijn korte strings naast knoppen waarmee er een keuze gemaakt wordt";
    }

    public void setRightSidePane(RightSidePane rightSidePane){
        super.setRightSidePane(rightSidePane);
        createTitledPane();
    }

    public void fill(){
        super.fill();
        titledPane.setLabelText(topDescriptionText);
        addBottomButtons();
    }
}
