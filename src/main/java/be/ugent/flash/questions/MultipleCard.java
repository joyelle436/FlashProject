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
public class MultipleCard extends Type {

    private final GridPane gridpane;
    private final Button okay;
    //string als key en T of F als value
    private final Map<String, Character> correctSelected;
    private final int numberOfCorrect;
    //lijst met alle toegevoegde checkbox
    private final CheckBox[] checkBoxList;
    public MultipleCard(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers) {
        super(stage, row, answers);
        checkBoxList = new CheckBox[answers.size()];
        gridpane = new GridPane();
        okay = new Button("OK");
        okay.setId("okay");
        correctSelected = new HashMap<>();
        numberOfCorrect = (int) new String(row.get(5)).chars().filter(ch -> ch == 'T').count();
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
            int counting = 0;
            for(CheckBox checkBox: checkBoxList){
                if(checkBox.isSelected()){
                    counting++;
                    answerFound = answerFound && correctSelected.get(checkBox.getText()) == 'T';
                }
            }
            answerFound = answerFound && counting == numberOfCorrect;
            this.goToNext = true;
            Platform.exit();
        });
    }
}
