package be.ugent.flash.factories;

import be.ugent.flash.cards.*;
import be.ugent.flash.data.Part;
import be.ugent.flash.data.Question;
import javafx.stage.Stage;

import java.util.*;

/**
 * {@link CompactCard} factory
 */
public class CompactFactory implements TypeFactory {
    @Override
    public Type makeCard(Stage stage, Question questionRow) {
        return new CompactCard(stage, questionRow);
    }
}
