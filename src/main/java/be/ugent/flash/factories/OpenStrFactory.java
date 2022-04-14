package be.ugent.flash.factories;

import be.ugent.flash.cards.OpenQuestion;
import be.ugent.flash.cards.OpenStrCard;
import be.ugent.flash.cards.Type;
import be.ugent.flash.data.Question;
import javafx.stage.Stage;

public class OpenStrFactory implements TypeFactory {
    @Override
    public Type makeCard(Stage stage, Question questionRow) {
        return new OpenStrCard(stage, questionRow);
    }
}
