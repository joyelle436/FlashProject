package be.ugent.flash.visitors;

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
        List<byte[]> row = openQuestion.getRow();
        GridPane gridPane = openQuestion.getGridPane();
        gridPane.getColumnConstraints().add(new ColumnConstraints(400));
        gridPane.getChildren().addAll(openQuestion.getAnswerField(), openQuestion.getFoutlabel());
        if(row.get(3) != null){
            openQuestion.setBottom(gridPane);
            BorderPane.setMargin(gridPane, new Insets(0, 15, 100, 20));
        } else {
            openQuestion.setCenter(gridPane);
            BorderPane.setMargin(gridPane, new Insets(20, 0, 0, 25));
        }
        openQuestion.handleEvents();
    }
}
