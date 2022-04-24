package be.ugent.flash.cardspanes;

import be.ugent.flash.command.AnswerChoiceTextField;
import javafx.scene.layout.GridPane;

public class TitledPaneGridpane extends GridPane {

    private int rowIndex;
    private final OptionButton optionButton;
    public TitledPaneGridpane(){
        this.rowIndex = 1;
        this.optionButton = new OptionButton();
        getChildren().add(optionButton);
        setVgap(7);
    }

    public OptionButton getOptionButton() {
        return optionButton;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public void addTextField(AnswerChoiceTextField choiceTextField) {
        setRowIndex(rowIndex+1);
    }
}
