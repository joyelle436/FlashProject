package be.ugent.flash.factories;

import be.ugent.flash.cards.OpenStrCard;
import be.ugent.flash.cards.Type;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class OpenStrFactory implements QuestionFactory {
    @Override
    public Type makeQuiz(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        return new OpenStrCard(stage, row, answers, nextCard);
    }
}
