package be.ugent.flash.viewer.factories;

import be.ugent.flash.viewer.cards.*;
import be.ugent.flash.data.Question;
import javafx.stage.Stage;

/**
 * {@link OpenIntCard} factory
 */
public class OpenIntFactory implements TypeFactory {
    @Override
    public Type makeCard(Stage stage, Question questionRow) {
        return new OpenIntCard(stage, questionRow);
    }
}
