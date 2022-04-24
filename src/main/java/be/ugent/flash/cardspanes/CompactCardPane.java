package be.ugent.flash.cardspanes;

/**
 * mcc
 */

import be.ugent.flash.command.PartData;
import be.ugent.flash.command.RightSidePane;

import java.util.List;

public class CompactCardPane extends CardPane {
    public CompactCardPane(String type){
        super(type);
        this.topDescriptionText = "Er zijn korte strings naast knoppen waarmee er een keuze gemaakt wordt";
    }

    public void setRightSidePane(RightSidePane rightSidePane, List<PartData> partDataList){
        super.setRightSidePane(rightSidePane, partDataList);
        createTitledPane();
    }

    public void fill(){
        super.fill();
        titledPane.setLabelText(topDescriptionText);
        addBottomButtons();
    }
}
