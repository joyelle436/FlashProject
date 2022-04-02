package be.ugent.flash.visitors;

import be.ugent.flash.questions.MultipleCard;
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
        List<byte[]> answersStrings = new ArrayList<>(multipleCard.getAnswers().values());
        String line  = new String(multipleCard.getRow().get(5));// string met TF
        for(int i=0; i < answersStrings.size(); i++){
            String possibleAnswer = new String(answersStrings.get(i));//antwoord
            multipleCard.addCorrespondingChar(possibleAnswer, line.charAt(i));
            CheckBox checkBox = new CheckBox(possibleAnswer);
            checkBox.setId("checkbox");
            multipleCard.addToChackbox(i, checkBox);
            GridPane.setConstraints(checkBox, 0, i);
        }
        GridPane gridPane = multipleCard.getGridPane();
        gridPane.getChildren().addAll(multipleCard.getCheckBoxList());
        gridPane.getColumnConstraints().add(new ColumnConstraints(300));
        gridPane.getChildren().add(multipleCard.getOkay());
        GridPane.setConstraints(multipleCard.getOkay(), gridPane.getColumnCount()+1, gridPane.getRowCount());
        gridPane.getColumnConstraints().add(new ColumnConstraints(50));
        gridPane.setVgap(10);
        multipleCard.setBottom(gridPane);
        BorderPane.setMargin(gridPane, new Insets(0, 5, 50, 15));
        multipleCard.handleEvents();
    }
}