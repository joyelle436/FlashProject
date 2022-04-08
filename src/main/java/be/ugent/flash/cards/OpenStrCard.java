package be.ugent.flash.cards;

import be.ugent.flash.CardModel;
import be.ugent.flash.QuestionRow;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.*;

/**
 * open
 */
public class OpenStrCard extends OpenQuestion implements InvalidationListener {

    public OpenStrCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers) {
        super(stage, questionRow, answers);
        errorlabel.setText("Antwoord kan niet leeg zijn");
    }

    public void setModel(CardModel model){
        this.model = model;
        model.addListener(this);
    }


    public void handleEvents(){
        setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                if(answerField.getText().equals("")){
                    answerField.getStyleClass().add("changeBorder");
                    errorlabel.getStyleClass().add("changeText");
                    errorlabel.setVisible(true);
                } else {
                    String answerText = answerField.getText().trim();
                    answerFound = answerText.equalsIgnoreCase(questionRow.correctAnswer());
                    showNextCard();
                    if(answerFound){
                        model.removeCard(this);
                    } else {
                        model.addAsFirst(this);
                    }
                    System.out.println(isAnswerFound());
                }
            }
        });
    }

    @Override
    public void invalidated(Observable observable) {
        int index = model.getAllCards().indexOf(this);
        model.change(index);
    }
}
