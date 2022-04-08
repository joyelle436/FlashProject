package be.ugent.flash.factories;

import be.ugent.flash.CardModel;
import be.ugent.flash.QuestionRow;
import be.ugent.flash.cards.MultipleCard;
import be.ugent.flash.cards.Type;
import javafx.stage.Stage;

import java.util.*;

/**
 * {@link MultipleCard} factory
 */
public class MultipleFactory implements QuestionFactory {
    @Override
    public Type makeCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers) {
        return new MultipleCard(stage, questionRow, answers);
    }
}
