package be.ugent.flash.cardspanes;

import be.ugent.flash.command.RedPopUp;
import be.ugent.flash.command.rights.AnswerChoiceObject;
import be.ugent.flash.command.rights.RightSidePane;

import java.sql.SQLException;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * mcs, mcc en mci
 */
public class SingleAnswerCardPane extends CardPane {
    public SingleAnswerCardPane(String type) {
        super(type);
        if(type.equals("mcc")){
            this.topDescriptionText = "Keuzes zijn strings op knopen waarop je kan opklikken om te antwoorden";
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
        correct = "";
        Queue<AnswerChoiceObject> choiceObjectQueue = titledPane.getMainGridpane().getChoiceObjectQueue();
        if(choiceObjectQueue.isEmpty()){
            new RedPopUp("Er moet minstens één mogelijk antwoord toegevoegd worden");
            return false;
        }
        List<AnswerChoiceObject> selectedObject = choiceObjectQueue.stream()
                .filter(AnswerChoiceObject::isSelected).toList();
        if(selectedObject.size() != 1){
            new RedPopUp("Er moet precies één antwoord zijn aangevinkt");
            return false;
        }
        correct = "" + (titledPane.getMainGridpane().getChildren().indexOf(selectedObject.get(0))-2);
        return super.updateQuestion();
    }
}