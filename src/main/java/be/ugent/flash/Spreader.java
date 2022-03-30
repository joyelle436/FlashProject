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
    private final List<List<byte[]>> questions;
    private final Map<Integer, Map<Integer, byte[]>> answers;

    public Spreader(Stage stage, List<List<byte[]>> questions, Map<Integer, Map<Integer, byte[]>> answers){
        this.stage = stage;
        this.questions = questions;
        this.answers = answers;
    }

    public void divideQuestions() throws IOException {
        List<byte[]> row = questions.get(3);
        String id = new String(row.get(0));
        Type type = new Multiple(stage, row, answers.get(Integer.parseInt(id)));
        type.build();
        type.showQuestion();
    }
}
