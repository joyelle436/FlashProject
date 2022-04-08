package be.ugent.flash.cards;

import be.ugent.flash.CardModel;
import be.ugent.flash.QuestionRow;
import be.ugent.flash.visitors.CardItem;
import be.ugent.flash.visitors.CardVisitor;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * mr
 */
public class MultipleCard extends Type implements CardItem<MultipleCard>, InvalidationListener {

    private final Button okay;
    private final Map<String, Character> correspondingChar;
    private final int numberOfCorrect;
    private final CheckBox[] checkBoxList;
    public MultipleCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers) {
        super(stage, questionRow, answers);
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

    public CheckBox[] getCheckBoxList() {
        return checkBoxList;
    }

    /**
     * lijst die alle chechbox bevat die als antwoord dienen
     */
    public void addToCheckbox(int index, CheckBox checkBox){
        checkBoxList[index] = checkBox;
    }

    /**
     * komt de antwoord overeen met T of F
     */
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
            int onlyCorrect = (int) Arrays.stream(checkBoxList)
                    .filter(CheckBox::isSelected)
                    .filter(checkBox -> correspondingChar.get(checkBox.getText()) == 'T').count();

            int selected = (int) Arrays.stream(checkBoxList).filter(CheckBox::isSelected).count();

            answerFound = numberOfCorrect == onlyCorrect && onlyCorrect == selected;
            showNextCard();
            if(answerFound){
                model.removeCard(this);
            } else {
                model.addAsFirst(this);
            }
            System.out.println(answerFound);

        });
    }

    public void setModel(CardModel model){
        this.model = model;
        model.addListener(this);
    }

    @Override
    public void accept(CardVisitor<MultipleCard> cardVisitor) {
        cardVisitor.visit(this);
    }

    @Override
    public void invalidated(Observable observable) {
        int index = model.getAllCards().indexOf(this);
        model.change(index);
    }
}