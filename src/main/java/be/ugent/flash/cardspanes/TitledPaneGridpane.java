package be.ugent.flash.cardspanes;

import be.ugent.flash.command.rights.AnswerChoiceObject;
import be.ugent.flash.command.rights.RightController;
import javafx.scene.layout.GridPane;

import java.util.HashSet;
import java.util.Set;

/**
 * Staat in de {@link CenterTitledPane} en bevat {@link OptionButton} en
 * {@link be.ugent.flash.command.rights.AnswerChoiceObject}
 */

public class TitledPaneGridpane extends GridPane {

    private final OptionButton optionButton;
    private final String questionType;
    private int rowPosition;
    private final Set<AnswerChoiceObject> choiceObjectSet;
    private final RightController rightController;
    public TitledPaneGridpane(String questionType, RightController rightController){
        this.optionButton = new OptionButton(this);
        this.rightController = rightController;
        this.questionType = questionType;
        this.rowPosition = 1;
        this.choiceObjectSet = new HashSet<>();
        getChildren().add(optionButton);
        setVgap(7);
    }


    public void putInSet(AnswerChoiceObject choiceObject){
        choiceObjectSet.add(choiceObject);
    }

    public void removeFromSet(AnswerChoiceObject choiceObject){
        choiceObjectSet.remove(choiceObject);
    }

    public Set<AnswerChoiceObject> getChoiceObjectSet() {
        return choiceObjectSet;
    }

    public RightController getRightController() {
        return rightController;
    }

    public String getQuestionType() {
        return questionType;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }

    public OptionButton getOptionButton() {
        return optionButton;
    }

    public void changeChildrenPosition(Integer rowIndex){
        for(AnswerChoiceObject choiceObject: choiceObjectSet){
            if(GridPane.getRowIndex(choiceObject) > rowIndex){
                choiceObject.decreasePosition();
            }
        }
    }
}