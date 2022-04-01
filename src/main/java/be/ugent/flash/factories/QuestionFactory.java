package be.ugent.flash.factories;

import be.ugent.flash.questions.Type;
import javafx.stage.Stage;

import java.util.*;

public interface QuestionFactory {
    public Type makeQuiz(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard);
}
