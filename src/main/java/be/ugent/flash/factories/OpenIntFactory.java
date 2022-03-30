package be.ugent.flash.factories;

import be.ugent.flash.questions.OpenIntCard;
import be.ugent.flash.questions.Type;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class OpenIntFactory implements QuestionFactory {
    @Override
    public Type makeQuiz(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers) {
        return new OpenIntCard(stage, row, answers);
    }
}
