package be.ugent.flash.cards;

import be.ugent.flash.visitors.CardItem;
import be.ugent.flash.visitors.CardVisitor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * mr
 */
public class MultipleCard extends Type implements CardItem<MultipleCard> {

    private final Button okay;
    //string als key en T of F als value
    private final Map<String, Character> correspondingChar;
    private final int numberOfCorrect;
    //lijst met alle toegevoegde checkbox
    private final CheckBox[] checkBoxList;
    public MultipleCard(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, row, answers, nextCard);
        checkBoxList = new CheckBox[answers.size()];
        okay = new Button("OK");
        okay.setId("okay");
        correspondingChar = new HashMap<>();
        numberOfCorrect = (int) new String(row.get(5)).chars().filter(ch -> ch == 'T').count();
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

    public void addToChackbox(int index, CheckBox checkBox){
        checkBoxList[index] = checkBox;
    }

    public char getCorrespondingChar(String answer) {
        return correspondingChar.get(answer);
    }

    public void addCorrespondingChar(String answer, char letter){
        correspondingChar.put(answer, letter);
    }

    public void handleEvents() {
        okay.setOnMouseClicked(mouseEvent -> {
            int counting = 0;
            for(CheckBox checkBox: checkBoxList){
                if(checkBox.isSelected() && correspondingChar.get(checkBox.getText()) == 'T'){
                    counting++;
                }
            }
            answerFound = counting == numberOfCorrect;
            goToNext = true;
            showNextCard();
        });
    }

    @Override
    public void accept(CardVisitor<MultipleCard> cardVisitor) {
        cardVisitor.visit(this);
    }
}