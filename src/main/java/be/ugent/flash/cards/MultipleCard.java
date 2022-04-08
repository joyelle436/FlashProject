package be.ugent.flash.cards;

import be.ugent.flash.QuestionRow;
import be.ugent.flash.visitors.CardItem;
import be.ugent.flash.visitors.CardVisitor;
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
    public MultipleCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, questionRow, answers, nextCard);
        checkBoxList = new CheckBox[answers.size()];
        okay = new Button("OK");
        okay.setId("okay");
        correspondingChar = new HashMap<>();
        numberOfCorrect = (int)questionRow.correctAnswer().chars().filter(ch -> ch == 'T').count();
    }

    @Override
    public void clear() {
        Arrays.stream(checkBoxList).toList().forEach(checkBox -> checkBox.setSelected(false));
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

    //lijst die alle chechbox bevat die als antwoord dienen
    public void addToCheckbox(int index, CheckBox checkBox){
        checkBoxList[index] = checkBox;
    }

    //komt de antwoord overeen met T of F
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