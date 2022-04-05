package be.ugent.flash.factories;

import be.ugent.flash.cards.PictureCard;
import be.ugent.flash.cards.Type;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class PictureFactory implements QuestionFactory {
    @Override
    public Type makeQuiz(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        return new PictureCard(stage, row, answers, nextCard);
    }
}
