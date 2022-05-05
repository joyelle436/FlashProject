package be.ugent.flash.command;

import be.ugent.flash.ViewerMapMaker;
import be.ugent.flash.cardspanes.CardPane;
import be.ugent.flash.command.right.buttons.Preview;
import be.ugent.flash.data.Part;
import be.ugent.flash.data.Question;
import be.ugent.flash.viewer.ErrorDisplay;
import be.ugent.flash.viewer.cards.Type;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

/**
 * Gemaakt in {@link Preview} als er opgeklikt wordt
 */
public class QuestionPreview extends Stage {
    private final ViewerMapMaker viewerMapMaker;
    private final CardPane cardPane;
    public QuestionPreview(CardPane cardPane){
        this.cardPane = cardPane;
        this.viewerMapMaker = new ViewerMapMaker();
        viewerMapMaker.makeFactoryMap();
        viewerMapMaker.makeVisitorMap();
    }

    public void showPreview() {
        try {
            CardUpdater cardUpdater = new CardUpdater(cardPane);
            Question updatedQuestion = cardUpdater.getUpdatedQuestion(true);
            List<Part> partList = cardUpdater.getPartList();
            Type type = viewerMapMaker.getFactory(updatedQuestion.questionType()).makeCard(this, updatedQuestion);
            if(partList != null){
                partList.removeIf(part -> part.part() == null);
                type.setAnswers(partList);
            }
            //noinspection unchecked
            viewerMapMaker.getVisitor(updatedQuestion.questionType()).buildCard(type);
            type.showQuestion();
        } catch (SQLException e) {
            ErrorDisplay.showAlert("Fout met het inladen van de preview");
        }
    }
}
