package be.ugent.flash.cards;

import be.ugent.flash.data.Part;
import be.ugent.flash.data.Question;
import be.ugent.flash.visitors.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * mr
 */
public class MultipleCard extends Type implements CardItem<MultipleCard> {

    private final Button okay;
    private final Map<String, Character> correspondingChar;
    private final int numberOfCorrect;
    private CheckBox[] checkBoxList;
    public MultipleCard(Stage stage, Question questionRow) {
        super(stage, questionRow);
        okay = new Button("OK");
        okay.setId("okay");
        correspondingChar = new HashMap<>();
        numberOfCorrect = (int)questionRow.correctAnswer().chars().filter(ch -> ch == 'T').count();
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

    public void addCorrespondingChar(String answer, char letter){
        correspondingChar.put(answer, letter);
    }

    public void clear() {
        super.clear();
        Arrays.stream(checkBoxList).toList().forEach(checkBox -> checkBox.setSelected(false));
    }

    public void handleEvents() {
        okay.setOnAction(actionEvent -> {
            int onlyCorrect = (int) Arrays.stream(checkBoxList)
                    .filter(CheckBox::isSelected)
                    .filter(checkBox -> correspondingChar.get(checkBox.getText()) == 'T').count();

            int selected = (int) Arrays.stream(checkBoxList).filter(CheckBox::isSelected).count();
            answerFound = numberOfCorrect == onlyCorrect && onlyCorrect == selected;
            if(answerFound){
                model.removeCard(this);
            } else {
                model.addAsLast(this);
            }
        });
    }

    public void setAnswers(List<Part> answers){
        this.answers = answers;
        checkBoxList = new CheckBox[answers.size()];
    }

    @Override
    public void accept(CardVisitor<MultipleCard> cardVisitor) {
        cardVisitor.visit(this);
    }
}