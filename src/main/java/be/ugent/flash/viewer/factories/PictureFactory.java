package be.ugent.flash.viewer.factories;

import be.ugent.flash.viewer.cards.PictureCard;
import be.ugent.flash.viewer.cards.Type;
import be.ugent.flash.data.Question;
import javafx.stage.Stage;

public class PictureFactory implements TypeFactory {
    @Override
    public Type makeCard(Stage stage, Question questionRow) {
        return new PictureCard(stage, questionRow);
    }
}
