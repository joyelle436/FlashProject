package be.ugent.flash.cardspanes;

import be.ugent.flash.command.RedPopUp;
import be.ugent.flash.command.rights.AnswerChoiceObject;
import be.ugent.flash.command.rights.RightSidePane;

import java.sql.SQLException;
import java.util.Set;


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
        Set<AnswerChoiceObject> choiceObjectSet = titledPane.getMainGridpane().getChoiceObjectSet();
        if(choiceObjectSet.isEmpty()){
            new RedPopUp("Er moet minstens één antwoord toegevoegd worden");
            return false;
        }
        for(AnswerChoiceObject choiceObject: titledPane.getMainGridpane().getChoiceObjectSet()){
            if(choiceObject.isSelected()){
                correct += "T";
            } else {
                correct += "F";
            }
        }
        return super.updateQuestion();
    }
}
