package be.ugent.flash.factories;

import be.ugent.flash.questions.PictureCard;
import be.ugent.flash.questions.Type;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class PictureFactory implements QuestionFactory {
    @Override
    public Type makeQuiz(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers) {
        return new PictureCard(stage, row, answers);
    }
}
