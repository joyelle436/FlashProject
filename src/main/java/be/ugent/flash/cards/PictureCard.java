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
 * mci
 */
public class PictureCard extends Type implements CardItem<PictureCard>, InvalidationListener {
    private final ToggleGroup picturegroup;
    //key togglebutton, value: antwoord part id
    private final Map<ToggleButton, Integer> toggleAnswers;
    public PictureCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers) {
        super(stage, questionRow, answers);
        toggleAnswers = new HashMap<>();
        picturegroup = new ToggleGroup();
    }

    @Override
    public void clear() {
        picturegroup.getToggles().forEach(toggle -> toggle.setSelected(false));
    }

    public ToggleGroup getPicturegroup() {
        return picturegroup;
    }

    public void addToggleButton(ToggleButton toggleButton){
        picturegroup.getToggles().add(toggleButton);
    }
    // om te weten welke togglebutton correspondeert met welke antwoord nummer voor de events
    public void addToToggleAnswer(ToggleButton toggleButton, Integer answer){
        toggleAnswers.put(toggleButton, answer);
    }

    public void setModel(CardModel model){
        this.model = model;
        model.addListener(this);
    }

    public void handleEvents() {
        for(int t = 0; t < picturegroup.getToggles().size(); t++){
            ToggleButton selectedToggle = (ToggleButton) picturegroup.getToggles().get(t);
            selectedToggle.setOnMouseClicked(mouseEvent -> {
                String selected = String.valueOf(toggleAnswers.get(selectedToggle));
                int index = Integer.parseInt(questionRow.correctAnswer());
                String correct = String.valueOf(new ArrayList<>(answers.keySet()).get(index));
                answerFound = selected.equals(correct);
                showNextCard();
                if(answerFound){
                    model.removeCard(this);
                } else {
                    model.addAsFirst(this);
                }
                System.out.println(isAnswerFound());
            });
        }
    }

    @Override
    public void accept(CardVisitor<PictureCard> cardVisitor) {
        cardVisitor.visit(this);
    }

    @Override
    public void invalidated(Observable observable) {
        int index = model.getAllCards().indexOf(this);
        model.change(index);
    }
}
