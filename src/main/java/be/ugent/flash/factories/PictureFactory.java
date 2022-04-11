package be.ugent.flash.factories;

import be.ugent.flash.cards.PictureCard;
import be.ugent.flash.cards.Type;
import be.ugent.flash.data.Question;
import javafx.stage.Stage;

public class PictureFactory implements TypeFactory {
    @Override
    public Type makeCard(Stage stage, Question questionRow) {
        return new PictureCard(stage, questionRow);
    }
}
