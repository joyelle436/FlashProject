package be.ugent.flash.cardspanes;

import be.ugent.flash.command.AnswerChoiceTextField;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class TitledPaneGridpane extends GridPane {

    private int rowIndex;
    private Button addOption;
    public TitledPaneGridpane(){
        this.rowIndex = 0;
        this.addOption = new Button("Optie toevoegen");
        getColumnConstraints().add(new ColumnConstraints(650));
        setVgap(7);
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
        GridPane.setConstraints(addOption, 0, rowIndex);
    }

    public void addTextField(AnswerChoiceTextField choiceTextField) {
        GridPane.setConstraints(choiceTextField, 0, rowIndex);
        setRowIndex(rowIndex+1);
    }
}
