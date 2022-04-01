package be.ugent.flash.factories;

import be.ugent.flash.questions.CompactCard;
import be.ugent.flash.questions.Type;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class CompactFactory implements QuestionFactory {
    @Override
    public Type makeQuiz(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        return new CompactCard(stage, row, answers, nextCard);
    }
}
