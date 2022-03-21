package be.ugent.flash;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Dit klasse verdeelt elke type vraag in een bepaalde klasse
 */

public class Type {

    private final Stage stage;
    private final List<String[]> questions;

    public Type(Stage stage, List<String[]> questions){
        this.stage = stage;
        this.questions = questions;
    }

    public void divideQuestions() throws IOException {
        new Question(questions.get(5), stage).showQuestion();
    }
}
