package be.ugent.flash.cards;

import be.ugent.flash.QuestionRow;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.*;


/**
 * openi
 */
public class OpenIntCard extends OpenQuestion {

    public OpenIntCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, questionRow, answers, nextCard);
        foutlabel.setText("Antwoord moet een geheel getal zijn");
    }

    public void handleEvents(){
        setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                String answer = answerField.getText();
                try {
                    int answerInt = Integer.parseInt(answer);
                    answerFound = answerInt == Integer.parseInt(questionRow.correctAnswer());
                    goToNext = true;
                    showNextCard();
                } catch (NumberFormatException ex){
                    answerField.getStyleClass().add("changeBorder");
                    foutlabel.getStyleClass().add("changeText");
                    foutlabel.setVisible(true);
                }
            }
        });
    }
}
