package be.ugent.flash.cardspanes;

import be.ugent.flash.command.rights.RightSidePane;


/**
 * mr
 */
public class MultipleCardPane extends CardPane {
    public MultipleCardPane(String type){
        super(type);
        this.topDescriptionText = "Antwoorden worden aan of uitvinkt. Mogelijkheden: meer dan één antwoord of geen";
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
