package be.ugent.flash.cardspanes;

import be.ugent.flash.command.PartData;
import be.ugent.flash.command.rights.RightSidePane;

import java.util.List;

/**
 * mcs
 */
public class StandaardCardPane extends CardPane {

    public StandaardCardPane(String type){
        super(type);
        this.topDescriptionText = "Antwoorden staan op knopen waarop er opgeklikt moet worden";
    }

    public void setRightSidePane(RightSidePane rightSidePane, List<PartData> partDataList){
        super.setRightSidePane(rightSidePane, partDataList);
        createTitledPane();
    }

    public void fill(){
        super.fill();
        titledPane.setLabelText("Keuzes worden onder elkaar getoond - met knopen A, B, C...");
        addBottomButtons();
    }
}
