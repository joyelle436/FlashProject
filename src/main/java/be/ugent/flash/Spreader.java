package be.ugent.flash;

import be.ugent.flash.questions.*;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Dit klasse verdeelt elke type vraag in een bepaalde klasse
 */

public class Spreader {

    private final Stage stage;
    private final String DATA;
    private final List<String[]> questions;

    public Spreader(Stage stage, String DATA, List<String[]> questions){
        this.stage = stage;
        this.DATA = DATA;
        this.questions = questions;
    }

    public void divideQuestions() throws IOException {
        Type type = new Standard(stage, DATA, questions.get(0));
        type.build();
        type.showQuestion();
    }
}
