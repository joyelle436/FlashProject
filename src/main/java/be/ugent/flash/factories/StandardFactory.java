package be.ugent.flash.factories;

import be.ugent.flash.cards.StandardCard;
import be.ugent.flash.cards.Type;
import be.ugent.flash.data.Question;
import javafx.stage.Stage;


/**
 * {@link StandardCard} factory
 */

public class StandardFactory implements TypeFactory {
    @Override
    public Type makeCard(Stage stage, Question questionRow) {
        return new StandardCard(stage, questionRow);
    }
}
