package be.ugent.flash.cards;

import be.ugent.flash.QuestionRow;
import be.ugent.flash.visitors.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * mcc
 */
public class CompactCard extends Type implements CardItem<CompactCard> {

    private final ToggleGroup wordsgroup;
    public CompactCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers) {
        super(stage, questionRow, answers);
        this.wordsgroup = new ToggleGroup();
    }

    public void addToggleButton(ToggleButton toggleButton){
        wordsgroup.getToggles().add(toggleButton);
    }

    public void clear() {
        super.clear();
        wordsgroup.getToggles().forEach(toggle -> toggle.setSelected(false));
    }

    public void handleEvents() {
        for(int t = 0; t < wordsgroup.getToggles().size(); t++){
            ToggleButton selectedToggle = (ToggleButton) wordsgroup.getToggles().get(t);
            selectedToggle.setOnAction(actionEvent -> {
                //index van antwoord
                int key = new ArrayList<>(answers.keySet()).get((Integer.parseInt(questionRow.correctAnswer())));
                String selectedText = selectedToggle.getText();
                String correct = new String(answers.get(key));
                answerFound = selectedText.equals(correct);
                if(answerFound){
                    model.removeCard(this);
                } else {
                    model.addAsLast(this);
                }
            });
        }
    }

    @Override
    public void accept(CardVisitor<CompactCard> cardVisitor) {
        cardVisitor.visit(this);
    }
}