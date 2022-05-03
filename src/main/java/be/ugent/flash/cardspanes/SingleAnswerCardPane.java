package be.ugent.flash.cardspanes;

import be.ugent.flash.command.rights.RightSidePane;

import java.sql.SQLException;

/**
 * mcs, mcc en mci
 */
public class SingleAnswerCardPane extends CardPane {
    public SingleAnswerCardPane(String type) {
        super(type);
        if(type.equals("mcc")){
            this.topDescriptionText = "Keuzes zijn strings op knopen waarop je kan opklikken";
        } else if(type.equals("mcs")){
            this.topDescriptionText = "Keuzes worden onder elkaar getoond - met knopen A, B, C...";
        } else {
            this.topDescriptionText = "Keuzes zijn (kleine) afbeeldingen die naast elkaar getoond worden";
        }
    }

    public void setRightSidePane(RightSidePane rightSidePane){
        super.setRightSidePane(rightSidePane);
        createTitledPane();
    }

    public boolean updateQuestion() throws SQLException {
        System.out.println(titledPane.getMainGridpane().getChildren());

        return super.updateQuestion();
    }
}
