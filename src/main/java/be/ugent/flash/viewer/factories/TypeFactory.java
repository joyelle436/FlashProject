package be.ugent.flash.viewer.factories;

import be.ugent.flash.viewer.cards.Type;
import be.ugent.flash.data.Question;
import javafx.stage.Stage;

public interface TypeFactory {
    Type makeCard(Stage stage, Question questionRow);
}
