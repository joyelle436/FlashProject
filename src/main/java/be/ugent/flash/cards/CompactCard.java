package be.ugent.flash.cards;

import be.ugent.flash.CardModel;
import be.ugent.flash.QuestionRow;
import be.ugent.flash.visitors.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * mcc
 */
public class CompactCard extends Type implements CardItem<CompactCard>, InvalidationListener {

    private final ToggleGroup wordsgroup;
    public CompactCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers) {
        super(stage, questionRow, answers);
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
                showNextCard();
                if(answerFound){
                    model.removeCard(this);
                } else {
                    model.addAsFirst(this);
                }
                System.out.println(answerFound);
            });
        }
    }

    @Override
    public void setModel(CardModel model) {
        this.model = model;
        model.addListener(this);
    }

    @Override
    public void accept(CardVisitor<CompactCard> cardVisitor) {
        cardVisitor.visit(this);
    }

    @Override
    public void invalidated(Observable observable) {
        int index = model.getAllCards().indexOf(this);
        model.change(index);
    }
}