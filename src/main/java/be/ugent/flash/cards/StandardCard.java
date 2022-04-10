package be.ugent.flash.cards;

import be.ugent.flash.QuestionRow;
import be.ugent.flash.visitors.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * mcs
 */
public class StandardCard extends Type implements CardItem<StandardCard> {

    private final ToggleGroup lettersGroup;
    private final Label[] labels;
    public StandardCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers) {
        super(stage, questionRow, answers);
        labels = new Label[answers.size()];
        lettersGroup = new ToggleGroup();
    }

    public Label[] getLabels() {
        return labels;
    }

    public void addToggle(ToggleButton toggleButton){
        lettersGroup.getToggles().add(toggleButton);
    }

    public void addLabel(int index, Label label){
        labels[index] = label;
    }

    public void clear() {
        super.clear();
        lettersGroup.getToggles().forEach(toggle -> toggle.setSelected(false));
    }

    public void handleEvents() {
        for(int t = 0; t < lettersGroup.getToggles().size(); t++){
            ToggleButton selectedToggle = (ToggleButton) lettersGroup.getToggles().get(t);
            selectedToggle.setOnAction(actionEvent -> {
                //selectedToggle.isArmed();
                String selectedText = selectedToggle.getText().trim();
                char correctAnswer = (char) (Integer.parseInt(questionRow.correctAnswer())+65);
                answerFound = correctAnswer == selectedText.charAt(0);
                if(answerFound){
                    model.removeCard(this);
                } else {
                    model.addAsLast(this);
                }
            });
        }
    }

    @Override
    public void accept(CardVisitor<StandardCard> cardVisitor) {
        cardVisitor.visit(this);
    }
}