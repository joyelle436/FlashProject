package be.ugent.flash.viewer.cards;

import be.ugent.flash.data.Question;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;



/**
 * openi
 */
public class OpenIntCard extends OpenQuestion implements InvalidationListener {

    public OpenIntCard(Stage stage, Question questionRow) {
        super(stage, questionRow);
        errorlabel.setText("Antwoord moet een geheel getal zijn");
    }

    public void handleEvents(){
        setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                String answer = answerField.getText();
                try {
                    int answerInt = Integer.parseInt(answer);
                    answerFound = answerInt == Integer.parseInt(questionRow.correctAnswer());
                    if(answerFound){
                        model.removeCard(this);
                    } else {
                        model.addAsLast(this);
                    }
                } catch (NumberFormatException ex){
                    answerField.getStyleClass().addAll("changeBorder");
                    errorlabel.getStyleClass().addAll("changeText");
                    errorlabel.setVisible(true);
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
