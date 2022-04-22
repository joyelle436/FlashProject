package be.ugent.flash.cardspanes;

import be.ugent.flash.command.RightSidePane;

/**
 * mr
 */
public class MultipleCardPane extends CardPane {
    public MultipleCardPane(){
        this.topDescriptionText = "Antwoorden worden aan of uitvinkt. Mogelijkheden: meer dan één antwoord of geen";
    }

    public void setRightSidePane(RightSidePane rightSidePane){
        super.setRightSidePane(rightSidePane);
        createTitledPane();
    }

    public void fill(){
        super.fill();
        addBottomButtons();
    }
}
