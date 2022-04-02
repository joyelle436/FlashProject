package be.ugent.flash.questions;

import be.ugent.flash.visitors.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.*;

/**
 * mcs
 */
public class StandardCard extends Type implements CardItem<StandardCard> {

    private final ToggleGroup lettersGroup;
    private final Label[] labels;
    public StandardCard(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, row, answers, nextCard);
        labels = new Label[answers.size()];
        lettersGroup = new ToggleGroup();
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
            selectedToggle.setOnAction(actionEvent -> {
                String selectedText = selectedToggle.getText().trim();
                char correctAnswer = (char) (Integer.parseInt(new String(row.get(5)))-1+65);
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