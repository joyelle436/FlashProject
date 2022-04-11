package be.ugent.flash.factories;

import be.ugent.flash.cards.Type;
import be.ugent.flash.data.Question;
import javafx.stage.Stage;

public interface TypeFactory {
    Type makeCard(Stage stage, Question questionRow);
}
