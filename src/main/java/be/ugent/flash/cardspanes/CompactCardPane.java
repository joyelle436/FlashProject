package be.ugent.flash.cardspanes;


import be.ugent.flash.command.rights.RightSidePane;

/**
 * mcc
 */
public class CompactCardPane extends CardPane {
    public CompactCardPane(String type){
        super(type);
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
