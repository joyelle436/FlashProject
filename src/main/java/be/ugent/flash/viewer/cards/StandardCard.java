package be.ugent.flash.viewer.cards;

import be.ugent.flash.db.Part;
import be.ugent.flash.db.Question;
import be.ugent.flash.viewer.visitors.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * mcs
 */
public class StandardCard extends Type implements CardItem<StandardCard> {

    private final ToggleGroup lettersGroup;
    private Label[] labels;
    public StandardCard(Stage stage, Question questionRow) {
        super(stage, questionRow);
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
                String selectedText = selectedToggle.getText().trim();
                char correctAnswer = (char) (Integer.parseInt(questionRow.correctAnswer())+65);
                answerFound = correctAnswer == selectedText.charAt(0);
                verifyAnswer();
            });
        }
    }

    public void setAnswers(List<Part> answers){
        super.setAnswers(answers);
        this.labels = new Label[answers.size()];
    }

    @Override
    public void accept(CardVisitor<StandardCard> cardVisitor) {
        cardVisitor.visit(this);
    }
}