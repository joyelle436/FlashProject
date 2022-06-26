package be.ugent.flash.viewer.visitors;

import be.ugent.flash.viewer.cards.MultipleCard;
import be.ugent.flash.db.Part;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;

import java.util.*;

public class MultipleCardVisitor implements CardVisitor<MultipleCard>{

    @Override
    public void buildCard(MultipleCard multipleCard){
        multipleCard.accept(new MultipleCardVisitor());
    }
    @Override
    public void visit(MultipleCard multipleCard) {
        multipleCard.build();
        List<Part> answersStrings = multipleCard.getAnswers();
        String line = multipleCard.getQuestionRow().correctAnswer();// string met TF

        for(int i=0; i < answersStrings.size(); i++){
            String possibleAnswer = new String(answersStrings.get(i).part());//antwoord
            multipleCard.addCorrespondingChar(possibleAnswer, line.charAt(i));
            CheckBox checkBox = new CheckBox(possibleAnswer);
            checkBox.setId("checkbox");
            multipleCard.addToCheckbox(i, checkBox);
            GridPane.setConstraints(checkBox, 0, i);
        }
        GridPane answersGridPane = multipleCard.getAnswersGridPane();
        answersGridPane.getChildren().addAll(multipleCard.getCheckBoxList());
        answersGridPane.getColumnConstraints().add(new ColumnConstraints(300));
        answersGridPane.getChildren().add(multipleCard.getOkay());
        GridPane.setConstraints(multipleCard.getOkay(), answersGridPane.getColumnCount()+1, answersGridPane.getRowCount());
        answersGridPane.getColumnConstraints().add(new ColumnConstraints(50));
        answersGridPane.setVgap(10);
        multipleCard.setBottom(answersGridPane);
        BorderPane.setMargin(answersGridPane, new Insets(20));
        multipleCard.handleEvents();
    }
}