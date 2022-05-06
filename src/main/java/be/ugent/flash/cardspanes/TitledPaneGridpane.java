package be.ugent.flash.cardspanes;

import be.ugent.flash.command.ClickEventSimulator;
import be.ugent.flash.command.right.AnswerChoiceObject;
import be.ugent.flash.command.right.RightController;
import be.ugent.flash.data.Question;
import be.ugent.flash.viewer.ErrorDisplay;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Staat in de {@link CenterTitledPane} en bevat {@link OptionButton} en
 * {@link be.ugent.flash.command.right.AnswerChoiceObject}
 */

public class TitledPaneGridpane extends GridPane {

    private final OptionButton optionButton;
    private final String questionType;
    private int rowPosition;
    private final ArrayDeque<AnswerChoiceObject> choiceObjectQueue;
    private final RightController rightController;
    public TitledPaneGridpane(String questionType, RightController rightController){
        this.optionButton = new OptionButton(this);
        this.rightController = rightController;
        this.questionType = questionType;
        this.rowPosition = 1;
        this.choiceObjectQueue = new ArrayDeque<>();
        getChildren().add(optionButton);
        setVgap(7);
    }

    public void putInQueue(AnswerChoiceObject choiceObject){
        choiceObjectQueue.offerLast(choiceObject);
    }

    public void removeFromQueue(AnswerChoiceObject choiceObject){
        if(choiceObject.getIdPart() < Integer.MAX_VALUE){
            try {
                rightController.getMainController().getDatabaseUpdater().deletePart(choiceObject.getIdPart());
            } catch (SQLException e) {
                ErrorDisplay.showAlert(e.getMessage());
            }
        }
        choiceObjectQueue.remove(choiceObject);
    }

    public Queue<AnswerChoiceObject> getChoiceObjectQueue() {
        return choiceObjectQueue;
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
        for(AnswerChoiceObject choiceObject: choiceObjectQueue){
            if(GridPane.getRowIndex(choiceObject) > rowIndex){
                choiceObject.decreasePosition();
            }
        }
    }

    public void select(Question question) {
        int index = 0;
        for(AnswerChoiceObject choiceObject: choiceObjectQueue){
            if(question.correctAnswer().length() == 1 && index == Integer.parseInt(question.correctAnswer())){
                choiceObject.selectChoiceBox();
            } else if(question.correctAnswer().length() > 1 && question.correctAnswer().charAt(index) == 'T') {
                choiceObject.selectChoiceBox();
            }
            index++;
        }
    }
}