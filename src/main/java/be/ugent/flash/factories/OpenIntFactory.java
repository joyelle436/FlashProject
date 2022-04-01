package be.ugent.flash.factories;

import be.ugent.flash.questions.*;
import javafx.stage.Stage;

import java.util.*;

public class OpenIntFactory implements QuestionFactory {
    @Override
    public Type makeQuiz(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        return new OpenIntCard(stage, row, answers, nextCard);
    }
}
