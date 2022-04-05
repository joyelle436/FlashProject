package be.ugent.flash.cards;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.*;


/**
 * openi
 */
public class OpenIntCard extends OpenQuestion {

    public OpenIntCard(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, row, answers, nextCard);
        foutlabel.setText("Antwoord moet een geheel getal zijn");
    }

    public void handleEvents(){
        setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                String answer = answerField.getText();
                try {
                    int answerInt = Integer.parseInt(answer);
                    answerFound = answerInt == Integer.parseInt(new String(row.get(5)));
                    goToNext = true;
                    showNextCard();
                } catch (NumberFormatException ex){
                    answerField.getStyleClass().add("changeBorder");
                    foutlabel.setVisible(true);
                    foutlabel.getStyleClass().add("changeText");
                }
            }
        });
    }
}
