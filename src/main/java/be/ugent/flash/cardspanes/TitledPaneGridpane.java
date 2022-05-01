package be.ugent.flash.cardspanes;

import be.ugent.flash.command.rights.RightController;
import javafx.scene.layout.GridPane;

/**
 * Staat in de {@link CenterTitledPane} en bevat {@link OptionButton} en
 * {@link be.ugent.flash.command.rights.AnswerChoiceObject}'s
 */

public class TitledPaneGridpane extends GridPane {

    private final OptionButton optionButton;
    private final String questionType;
    private int rowPosition;
    private final RightController rightController;
    public TitledPaneGridpane(String questionType, RightController rightController){
        this.optionButton = new OptionButton(this);
        this.rightController = rightController;
        //setGridLinesVisible(true);
        this.questionType = questionType;
        getChildren().add(optionButton);
        setVgap(7);
        this.rowPosition = 1;
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
}
