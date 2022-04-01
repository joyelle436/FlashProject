package be.ugent.flash.questions;

import be.ugent.flash.visitors.CardItem;
import be.ugent.flash.visitors.CardVisitor;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * mr
 */
public class MultipleCard extends Type implements CardItem<MultipleCard> {

    private final GridPane gridpane;
    private final Button okay;
    //string als key en T of F als value
    private final Map<String, Character> correspondingChar;
    private final int numberOfCorrect;
    //lijst met alle toegevoegde checkbox
    private final CheckBox[] checkBoxList;
    public MultipleCard(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, row, answers, nextCard);
        checkBoxList = new CheckBox[answers.size()];
        gridpane = new GridPane();
        okay = new Button("OK");
        okay.setId("okay");
        correspondingChar = new HashMap<>();
        numberOfCorrect = (int) new String(row.get(5)).chars().filter(ch -> ch == 'T').count();
    }

    public GridPane getGridpane() {
        return gridpane;
    }

    public Button getOkay() {
        return okay;
    }

    public int getNumberOfCorrect() {
        return numberOfCorrect;
    }

    public CheckBox[] getCheckBoxList() {
        return checkBoxList;
    }

    public Map<String, Character> getCorrespondingChar() {
        return correspondingChar;
    }

    @Override
    public void build() {
        super.build();
        for(int i=0; i < answers.size(); i++){
            String possibility = new String(answers.get(new ArrayList<>(answers.keySet()).get(i)));//antwoord
            correspondingChar.put(possibility, new String(row.get(5)).charAt(i));
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
                    answerFound = answerFound && correspondingChar.get(checkBox.getText()) == 'T';
                }
            }
            answerFound = answerFound && counting == numberOfCorrect;
            showNextCard();
        });
    }

    @Override
    public void accept(CardVisitor cardVisitor) {
        cardVisitor.visit(this);
    }
}
