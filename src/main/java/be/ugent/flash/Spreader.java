package be.ugent.flash;

import be.ugent.flash.questions.Compact;
import be.ugent.flash.questions.Type;
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
    private final List<byte[]> mainImages;

    public Spreader(Stage stage, String DATA, List<String[]> questions, Map<String, List<String[]>> answers, List<byte[]> mainImages){
        this.stage = stage;
        this.DATA = DATA;
        this.questions = questions;
        this.answers = answers;
        this.mainImages = mainImages;
    }

    public void divideQuestions() throws IOException {
        String[] row = questions.get(1);
        Type type = new Compact(stage, DATA, row, answers.get(row[0]), mainImages.get(1));
        type.build();
        type.showQuestion();
    }
}
