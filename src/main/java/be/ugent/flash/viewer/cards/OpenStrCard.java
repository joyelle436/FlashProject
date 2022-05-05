package be.ugent.flash.viewer.cards;

import be.ugent.flash.data.Question;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;


/**
 * open
 */
public class OpenStrCard extends OpenQuestionCard {

    public OpenStrCard(Stage stage, Question questionRow) {
        super(stage, questionRow);
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
                    answerField.getStyleClass().addAll("changeBorder");
                    errorlabel.getStyleClass().addAll("changeText");
                    errorlabel.setVisible(true);
                } else {
                    String answerText = answerField.getText().trim();
                    answerFound = answerText.equalsIgnoreCase(questionRow.correctAnswer());
                    if(answerFound){
                        model.removeCard(this);
                    } else {
                        model.addAsLast(this);
                    }
                }
            }
        });
    }

}
