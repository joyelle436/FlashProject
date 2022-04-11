package be.ugent.flash.factories;

import be.ugent.flash.cards.*;
import be.ugent.flash.data.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * {@link MultipleCard} factory
 */
public class MultipleFactory implements TypeFactory {
    @Override
    public Type makeCard(Stage stage, Question questionRow) {
        return new MultipleCard(stage, questionRow);
    }
}
