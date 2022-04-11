package be.ugent.flash.factories;

import be.ugent.flash.QuestionRow;
import be.ugent.flash.cards.OpenQuestion;
import be.ugent.flash.cards.OpenStrCard;
import be.ugent.flash.cards.Type;
import be.ugent.flash.data.Question;
import javafx.stage.Stage;

import java.util.Map;

public class OpenStrFactory implements TypeFactory {
    @Override
    public OpenQuestion makeCard(Stage stage, Question questionRow) {
        return new OpenStrCard(stage, questionRow);
    }
}
