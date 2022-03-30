package be.ugent.flash.questions;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;

/**
 * mr
 */
public class Multiple extends Type {

    private final GridPane gridpane;
    private final Button okay;
    private final Map<String, Character> correctSelected;
    //lijst met alle toegevoegde checkbox
    private final CheckBox[] checkBoxList;
    public Multiple(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers) {
        super(stage, row, answers);
        checkBoxList = new CheckBox[answers.size()];
        gridpane = new GridPane();
        okay = new Button("OK");
        okay.setId("okay");
        correctSelected = new HashMap<>();
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(22.5));
        for(int i=0; i < answers.size(); i++){
            String possibility = new String(answers.get(new ArrayList<>(answers.keySet()).get(i)));//antwoord
            correctSelected.put(possibility, new String(row.get(5)).charAt(i));
            CheckBox checkBox = new CheckBox(possibility);
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

        okay.setOnAction(actionEvent -> {
            for(CheckBox checkBox: checkBoxList){
                if(checkBox.isSelected()){
                    answerFound = answerFound && correctSelected.get(checkBox.getText()) == 'T';
                }
            }
            Platform.exit();
        });
    }

}
