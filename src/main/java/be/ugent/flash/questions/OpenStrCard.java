package be.ugent.flash.questions;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.*;

/**
 * open
 */
public class OpenStrCard extends OpenQuestion {

    public OpenStrCard(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, row, answers, nextCard);
    }

    public void build(){
        super.build();
        foutlabel.setText("Antwoord kan niet leeg zijn");
        setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                if(answerField.getText().equals("")){
                    answerField.getStyleClass().add("changeBorder");
                    foutlabel.setVisible(true);
                    foutlabel.getStyleClass().add("changeText");
                } else {
                    String answerText = answerField.getText().trim();
                    answerFound = answerText.equals(new String(row.get(5)));
                    showNextCard();
                }
            }
        });
    }
}
