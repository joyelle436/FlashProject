package be.ugent.flash.factories;

import be.ugent.flash.QuestionRow;
import be.ugent.flash.cards.StandardCard;
import be.ugent.flash.cards.Type;
import javafx.stage.Stage;

import java.util.*;

/**
 * {@link StandardCard} factory
 */

public class StandardFactory implements QuestionFactory {
    @Override
    public Type makeCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers, Type nextCard) {
        return new StandardCard(stage, questionRow, answers, nextCard);
    }
}
