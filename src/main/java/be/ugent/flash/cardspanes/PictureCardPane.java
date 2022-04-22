package be.ugent.flash.cardspanes;

import be.ugent.flash.command.RightSidePane;

/**
 * mci
 */
public class PictureCardPane extends CardPane {
    public PictureCardPane(){
        this.topDescriptionText = "Keuzes zijn (kleine) afbeelding naast overeenkomstige antwoordknopen";
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
