package be.ugent.flash.cards;

import be.ugent.flash.QuestionRow;
import be.ugent.flash.visitors.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * mci
 */
public class PictureCard extends Type implements CardItem<PictureCard> {
    private final ToggleGroup picturegroup;
    //key togglebutton, value: antwoord part id
    private final Map<ToggleButton, Integer> toggleAnswers;
    public PictureCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers) {
        super(stage, questionRow, answers);
        toggleAnswers = new HashMap<>();
        picturegroup = new ToggleGroup();
    }

    public void clear() {
        super.clear();
        picturegroup.getToggles().forEach(toggle -> toggle.setSelected(false));
    }

    public void addToggleButton(ToggleButton toggleButton){
        picturegroup.getToggles().add(toggleButton);
    }
    // om te weten welke togglebutton correspondeert met welke antwoord nummer voor de events
    public void addToToggleAnswer(ToggleButton toggleButton, Integer answer){
        toggleAnswers.put(toggleButton, answer);
    }

    public void handleEvents() {
        for(int t = 0; t < picturegroup.getToggles().size(); t++){
            ToggleButton selectedToggle = (ToggleButton) picturegroup.getToggles().get(t);
            selectedToggle.setOnAction(actionEvent -> {
                String selected = String.valueOf(toggleAnswers.get(selectedToggle));
                int index = Integer.parseInt(questionRow.correctAnswer());
                String correct = String.valueOf(new ArrayList<>(answers.keySet()).get(index));
                answerFound = selected.equals(correct);
                if(answerFound){
                    model.removeCard(this);
                } else {
                    model.addAsLast(this);
                }
            });
        }
    }

    @Override
    public void accept(CardVisitor<PictureCard> cardVisitor) {
        cardVisitor.visit(this);
    }
}