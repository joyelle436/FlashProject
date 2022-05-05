package be.ugent.flash.cardspanes;

import be.ugent.flash.command.RedPopUp;
import be.ugent.flash.command.right.AnswerChoiceObject;
import be.ugent.flash.command.right.RightSidePane;

import java.sql.SQLException;
import java.util.Queue;


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

    public boolean updateQuestion(boolean preview) throws SQLException {
        correct = "";
        Queue<AnswerChoiceObject> choiceObjectQueue = titledPane.getMainGridpane().getChoiceObjectQueue();
        if(choiceObjectQueue.isEmpty()){
            new RedPopUp("Er moet minstens één mogelijk antwoord toegevoegd worden");
            return false;
        }
        for(AnswerChoiceObject choiceObject: titledPane.getMainGridpane().getChoiceObjectQueue()){
            if(choiceObject.isSelected()){
                correct += "T";
            } else {
                correct += "F";
            }
        }
        return super.updateQuestion(preview);
    }
}
