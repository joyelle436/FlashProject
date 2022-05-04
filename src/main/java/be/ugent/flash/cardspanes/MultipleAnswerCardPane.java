package be.ugent.flash.cardspanes;

import be.ugent.flash.command.RedPopUp;
import be.ugent.flash.command.rights.AnswerChoiceObject;
import be.ugent.flash.command.rights.RightSidePane;

import java.sql.SQLException;
import java.util.Queue;
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
        correct = "";
        Queue<AnswerChoiceObject> choiceObjectQueue = titledPane.getMainGridpane().getChoiceObjectQueue();
        if(choiceObjectQueue.isEmpty()){
            new RedPopUp("Er moet minstens één mogelijk antwoord toegevoegd worden");
            return false;
        }
        System.out.println(titledPane.getMainGridpane().getChoiceObjectQueue());
        for(AnswerChoiceObject choiceObject: titledPane.getMainGridpane().getChoiceObjectQueue()){
            if(choiceObject.isSelected()){
                correct += "T";
            } else {
                correct += "F";
            }
        }
        return super.updateQuestion();
    }
}
