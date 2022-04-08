package be.ugent.flash.cards;

import be.ugent.flash.QuestionRow;
import be.ugent.flash.visitors.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * mcc
 */
public class CompactCard extends Type implements CardItem<CompactCard>{

    private final ToggleGroup wordsgroup;
    public CompactCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, questionRow, answers, nextCard);
        this.wordsgroup = new ToggleGroup();
    }

    @Override
    public void clear() {
        wordsgroup.getToggles().forEach(toggle -> toggle.setSelected(false));
    }

    public ToggleGroup getWordsgroup() {
        return wordsgroup;
    }

    public void addToggleButton(ToggleButton toggleButton){
        wordsgroup.getToggles().add(toggleButton);
    }

    public void handleEvents() {
        for(int t = 0; t < wordsgroup.getToggles().size(); t++){
            ToggleButton selectedToggle = (ToggleButton) wordsgroup.getToggles().get(t);
            selectedToggle.setOnMouseClicked(mouseEvent -> {
                //index van antwoord
                int key = new ArrayList<>(answers.keySet()).get((Integer.parseInt(questionRow.correctAnswer())));
                String selectedText = selectedToggle.getText();
                answerFound = selectedText.equals(new String(answers.get(key)));
                goToNext = true;
                showNextCard();
            });
        }
    }

    @Override
    public void accept(CardVisitor<CompactCard> cardVisitor) {
        cardVisitor.visit(this);
    }
}