package be.ugent.flash.cards;

import be.ugent.flash.QuestionRow;
import be.ugent.flash.visitors.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * mcs
 */
public class StandardCard extends Type implements CardItem<StandardCard> {

    private final ToggleGroup lettersGroup;
    private final Label[] labels;
    public StandardCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, questionRow, answers, nextCard);
        labels = new Label[answers.size()];
        lettersGroup = new ToggleGroup();
    }

    @Override
    public void clear() {
        lettersGroup.getToggles().forEach(toggle -> toggle.setSelected(false));
    }

    public ToggleGroup getLettersGroup() {
        return lettersGroup;
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

    public void handleEvents() {
        for(int t = 0; t < lettersGroup.getToggles().size(); t++){
            ToggleButton selectedToggle = (ToggleButton) lettersGroup.getToggles().get(t);
            selectedToggle.setOnMouseClicked(mouseEvent -> {
                //selectedToggle.isArmed();
                String selectedText = selectedToggle.getText().trim();
                char correctAnswer = (char) (Integer.parseInt(questionRow.correctAnswer())+65);
                answerFound = correctAnswer == selectedText.charAt(0);
                goToNext = true;
                showNextCard();
            });
        }
    }

    @Override
    public void accept(CardVisitor<StandardCard> cardVisitor) {
        cardVisitor.visit(this);
    }
}