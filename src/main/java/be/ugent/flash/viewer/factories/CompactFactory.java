package be.ugent.flash.viewer.factories;

import be.ugent.flash.viewer.cards.*;
import be.ugent.flash.data.Question;
import javafx.stage.Stage;

/**
 * {@link CompactCard} factory
 */
public class CompactFactory implements TypeFactory {
    @Override
    public Type makeCard(Stage stage, Question questionRow) {
        return new CompactCard(stage, questionRow);
    }
}
