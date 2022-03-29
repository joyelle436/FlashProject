package be.ugent.flash;

import be.ugent.flash.questions.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

/**
 * Dit klasse verdeelt elke type vraag in een bepaalde klasse
 */

public class Spreader {

    private final Stage stage;
    private final String DATA;
    private final List<String[]> questions;
    private final Map<String, List<String[]>> answers;

    public Spreader(Stage stage, String DATA, List<String[]> questions, Map<String, List<String[]>> answers){
        this.stage = stage;
        this.DATA = DATA;
        this.questions = questions;
        this.answers = answers;
    }

    public void divideQuestions() throws IOException {
        String[] row = questions.get(3);
        Type type = new Multiple(stage, DATA, row, answers.get(row[0]));
        type.build();
        type.showQuestion();
    }
}
