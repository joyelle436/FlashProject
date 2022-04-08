package be.ugent.flash.factories;

import be.ugent.flash.QuestionRow;
import be.ugent.flash.cards.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * {@link OpenIntCard} factory
 */
public class OpenIntFactory implements QuestionFactory {
    @Override
    public Type makeCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers, Type nextCard) {
        return new OpenIntCard(stage, questionRow, answers, nextCard);
    }
}
