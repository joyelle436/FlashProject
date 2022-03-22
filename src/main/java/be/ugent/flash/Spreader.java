package be.ugent.flash;

import be.ugent.flash.questions.Question;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Dit klasse verdeelt elke type vraag in een bepaalde klasse
 */

public class Spreader {

    private final Stage stage;
    private final List<String[]> questions;

    public Spreader(Stage stage, List<String[]> questions){
        this.stage = stage;
        this.questions = questions;
    }

    public void divideQuestions() throws IOException {
        new Question(questions.get(5), stage).showQuestion();
    }
}
