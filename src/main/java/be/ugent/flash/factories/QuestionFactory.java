package be.ugent.flash.factories;

import be.ugent.flash.CardModel;
import be.ugent.flash.QuestionRow;
import be.ugent.flash.cards.Type;
import javafx.stage.Stage;

import java.util.*;

public interface QuestionFactory {
    public Type makeCard(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers);
}
