package be.ugent.flash.cardspanes;

import be.ugent.flash.command.rights.RightSidePane;


/**
 * mci
 */
public class PictureCardPane extends CardPane {
    public PictureCardPane(String type){
        super(type);
        this.topDescriptionText = "Afbeeldingen worden naast elkaar getoond als knopen";
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