package be.ugent.flash.viewer.factories;

import be.ugent.flash.viewer.cards.*;
import be.ugent.flash.data.*;
import javafx.stage.Stage;

/**
 * {@link MultipleCard} factory
 */
public class MultipleFactory implements TypeFactory {
    @Override
    public Type makeCard(Stage stage, Question questionRow) {
        return new MultipleCard(stage, questionRow);
    }
}
