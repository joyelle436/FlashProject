package be.ugent.flash.cardspanes;

import be.ugent.flash.command.PartData;
import be.ugent.flash.command.rights.RightSidePane;

import java.util.List;

/**
 * mci
 */
public class PictureCardPane extends CardPane {
    public PictureCardPane(String type){
        super(type);
        this.topDescriptionText = "Keuzes zijn (kleine) afbeelding om erop te klikken";
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
