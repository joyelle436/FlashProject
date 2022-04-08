package be.ugent.flash.factories;

import be.ugent.flash.QuestionRow;
import be.ugent.flash.cards.PictureCard;
import be.ugent.flash.cards.Type;
import javafx.stage.Stage;

import java.util.Map;

public class PictureFactory implements QuestionFactory {
    @Override
    public Type makeCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers) {
        return new PictureCard(stage, questionRow, answers);
    }
}
