package be.ugent.flash.cardspanes;

import be.ugent.flash.command.rights.RightSidePane;

import java.sql.SQLException;


/**
 * mr
 */
public class MultipleAnswerCardPane extends CardPane {
    public MultipleAnswerCardPane(String type){
        super(type);
        this.topDescriptionText = "Keuzes zijn checkboxes die aan/uitgevinkt kunnen worden";
    }

    public void setRightSidePane(RightSidePane rightSidePane){
        super.setRightSidePane(rightSidePane);
        createTitledPane();
    }

    public boolean updateQuestion() throws SQLException {
        return super.updateQuestion();
    }
}
