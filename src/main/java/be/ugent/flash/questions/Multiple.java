package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

/**
 * mr
 */
public class Multiple extends Type {

    private final GridPane gridpane;
    //uit de antwoorden die we krijgen door map in constructor
    private final String[] answersList;
    private Button okay;
    //lijst met alle toegevoegde checkbox
    private final CheckBox[] checkBoxList;
    public Multiple(Stage stage, String DATA, String[] row, List<String[]> answers, byte[] aByte) {
        super(stage, DATA, row, answers, aByte);
        checkBoxList = new CheckBox[answersSize];
        gridpane = new GridPane();
        answersList = new String[answersSize];
        okay = new Button("OK");
        okay.setId("okay");
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(22.5));
        for(int i=0; i < answersSize; i++){
            CheckBox checkBox = new CheckBox(answers.get(i)[1]);
            checkBox.setId("checkbox");
            checkBoxList[i] = checkBox;
            GridPane.setConstraints(checkBox, 0, i);
        }
        gridpane.getChildren().addAll(checkBoxList);
        gridpane.getColumnConstraints().add(new ColumnConstraints(300));
        gridpane.getChildren().add(okay);
        GridPane.setConstraints(okay, gridpane.getColumnCount()+1, gridpane.getRowCount());
        gridpane.getColumnConstraints().add(new ColumnConstraints(50));
        gridpane.setVgap(10);
        setBottom(gridpane);
        setMargin(gridpane, new Insets(0, 5, 50, 15));
        setMargin(textFlow, new Insets(50, 15, 0, 15));
    }

    @Override
    public void addImage() {

    }
}
