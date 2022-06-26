package be.ugent.flash.viewer.factories;

import be.ugent.flash.db.Question;
import be.ugent.flash.viewer.cards.*;
import javafx.stage.Stage;

public class CardFactory {

    public static class PictureFactory implements TypeFactory {
        @Override
        public Type makeCard(Stage stage, Question questionRow) {
            return new PictureCard(stage, questionRow);
        }
    }

    public static class CompactFactory implements TypeFactory {
        @Override
        public Type makeCard(Stage stage, Question questionRow) {
            return new CompactCard(stage, questionRow);
        }
    }

    public static class MultipleFactory implements TypeFactory {
        @Override
        public Type makeCard(Stage stage, Question questionRow) {
            return new MultipleCard(stage, questionRow);
        }
    }

    public static class StandardFactory implements TypeFactory {
        @Override
        public Type makeCard(Stage stage, Question questionRow) {
            return new StandardCard(stage, questionRow);
        }
    }

    public static class OpenIntFactory implements TypeFactory {
        @Override
        public Type makeCard(Stage stage, Question questionRow) {
            return new OpenIntCard(stage, questionRow);
        }
    }

    public static class OpenStrFactory implements TypeFactory {
        @Override
        public Type makeCard(Stage stage, Question questionRow) {
            return new OpenStrCard(stage, questionRow);
        }
    }
}