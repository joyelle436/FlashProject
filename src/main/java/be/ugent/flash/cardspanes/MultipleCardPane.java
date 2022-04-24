package be.ugent.flash.cardspanes;

import be.ugent.flash.command.PartData;
import be.ugent.flash.command.RightSidePane;

import java.util.List;

/**
 * mr
 */
public class MultipleCardPane extends CardPane {
    public MultipleCardPane(String type){
        super(type);
        this.topDescriptionText = "Antwoorden worden aan of uitvinkt. Mogelijkheden: meer dan één antwoord of geen";
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
