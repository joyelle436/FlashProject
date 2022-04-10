package be.ugent.flash.visitors;

import be.ugent.flash.QuestionRow;
import be.ugent.flash.cards.OpenQuestion;
import javafx.geometry.Insets;
import javafx.scene.layout.*;

import java.util.List;

public class OpenQuestionVisitor implements CardVisitor<OpenQuestion>{

    @Override
    public void buildCard(OpenQuestion openQuestion){
        openQuestion.accept(new OpenQuestionVisitor());
    }
    @Override
    public void visit(OpenQuestion openQuestion) {
        openQuestion.build();
        QuestionRow row = openQuestion.getQuestionRow();
        GridPane answersGridPane = openQuestion.getAnswersGridPane();
        answersGridPane.getColumnConstraints().add(new ColumnConstraints(400));
        answersGridPane.getChildren().addAll(openQuestion.getAnswerField(), openQuestion.getErrorlabel());
        if(row.middleImage() != null){
            openQuestion.setBottom(answersGridPane);
            BorderPane.setMargin(answersGridPane, new Insets(0, 15, 100, 20));
        } else {
            openQuestion.setCenter(answersGridPane);
            BorderPane.setMargin(answersGridPane, new Insets(20, 0, 0, 25));
        }
        openQuestion.handleEvents();
    }
}
