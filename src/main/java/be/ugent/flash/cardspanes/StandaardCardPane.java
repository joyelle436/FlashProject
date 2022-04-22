package be.ugent.flash.cardspanes;

import be.ugent.flash.command.RightSidePane;

/**
 * mcs
 */
public class StandaardCardPane extends CardPane {

    public StandaardCardPane(){
    }

    public void setRightSidePane(RightSidePane rightSidePane){
        super.setRightSidePane(rightSidePane);
        createTitledPane();
    }

    public void fill(){
        super.fill();
        titledPane.setLabelText("Keuzes worden onder elkaar getoond - met knopen A, B, C...");
        addBottomButtons();
    }
}
