package be.ugent.flash.viewer.visitors;

import be.ugent.flash.viewer.cards.OpenQuestion;
import be.ugent.flash.data.Question;
import javafx.geometry.Insets;
import javafx.scene.layout.*;


public class OpenQuestionVisitor implements CardVisitor<OpenQuestion>{

    @Override
    public void buildCard(OpenQuestion openQuestion){
        openQuestion.accept(new OpenQuestionVisitor());
    }
    @Override
    public void visit(OpenQuestion openQuestion) {
        openQuestion.build();
        Question row = openQuestion.getQuestionRow();
        GridPane answersGridPane = openQuestion.getAnswersGridPane();
        answersGridPane.getColumnConstraints().add(new ColumnConstraints(400));
        answersGridPane.getChildren().addAll(openQuestion.getAnswerField(), openQuestion.getErrorlabel());
        if(row.middleImage() != null){
            openQuestion.setBottom(answersGridPane);
            BorderPane.setMargin(answersGridPane, new Insets(20, 15, 100, 20));
        } else {
            openQuestion.setCenter(answersGridPane);
            BorderPane.setMargin(answersGridPane, new Insets(20, 0, 0, 25));
        }
        openQuestion.handleEvents();
    }
}
