package be.ugent.flash.cards;

import be.ugent.flash.data.*;
import be.ugent.flash.visitors.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.List;


/**
 * mcc
 */
public class CompactCard extends Type implements CardItem<CompactCard> {

    private final ToggleGroup wordsgroup;
    public CompactCard(Stage stage, Question questionRow) {
        super(stage, questionRow);
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
                String correct = new String(answers.get(Integer.parseInt(questionRow.correctAnswer())).part());
                String selectedText = selectedToggle.getText();
                answerFound = selectedText.equals(correct);
                if(answerFound){
                    model.removeCard(this);
                } else {
                    model.addAsLast(this);
                }
            });
        }
    }

    public void setAnswers(List<Part> answers){
        this.answers = answers;
    }

    @Override
    public void accept(CardVisitor<CompactCard> cardVisitor) {
        cardVisitor.visit(this);
    }
}