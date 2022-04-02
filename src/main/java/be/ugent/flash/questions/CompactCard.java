package be.ugent.flash.questions;

import be.ugent.flash.visitors.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * mcc
 */
public class CompactCard extends Type implements CardItem<CompactCard>{

    private final ToggleGroup wordsgroup;
    public CompactCard(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, row, answers, nextCard);
        this.wordsgroup = new ToggleGroup();
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
            selectedToggle.setOnAction(actionEvent -> {
                int key = new ArrayList<>(answers.keySet()).get((Integer.parseInt(new String(row.get(5))))-1);
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