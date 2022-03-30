package be.ugent.flash.questions;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;


/**
 * openi
 */
public class OpenIntCard extends OpenQuestion {

    public OpenIntCard(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers) {
        super(stage, row, answers);
    }

    public void build(){
        super.build();
        foutlabel.setText("Antwoord moet een geheel getal zijn");
        setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                String answer = answerField.getText();
                try {
                    int answerInt = Integer.parseInt(answer);
                    answerFound = answerInt == Integer.parseInt(new String(row.get(5)));
                    this.goToNext = true;
                    Platform.exit();
                } catch (NumberFormatException ex){
                    answerField.getStyleClass().add("changeBorder");
                    foutlabel.setVisible(true);
                    foutlabel.getStyleClass().add("changeText");
                }
            }
        });
    }
}
