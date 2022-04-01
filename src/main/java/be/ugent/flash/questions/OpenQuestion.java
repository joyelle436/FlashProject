package be.ugent.flash.questions;

import be.ugent.flash.visitors.CardItem;
import be.ugent.flash.visitors.CardVisitor;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;

public class OpenQuestion extends Type implements CardItem<OpenQuestion> {
    protected final TextField answerField;
    protected final Label foutlabel;
    protected OpenQuestion(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, row, answers, nextCard);
        this.answerField = new TextField();
        this.foutlabel = new Label();
    }

    public TextField getAnswerField() {
        return answerField;
    }

    public Label getFoutlabel() {
        return foutlabel;
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(25));
        GridPane gridPane = new GridPane();
        answerField.setId("textfield");
        foutlabel.setVisible(false);
        foutlabel.setFont(new Font(17.5));
        GridPane.setConstraints(answerField, 0, 0);
        GridPane.setConstraints(foutlabel, 0, 1);
        gridPane.getColumnConstraints().add(new ColumnConstraints(400));
        answerField.setMaxWidth(400);
        gridPane.getChildren().addAll(answerField, foutlabel);
        if(row.get(3) != null){
            setBottom(gridPane);
            setMargin(gridPane, new Insets(0, 15, 100, 20));
        } else {
            setCenter(gridPane);
            setMargin(textFlow, new Insets(150, 15, 0, 15));
            setMargin(gridPane, new Insets(20, 0, 0, 25));
        }
    }

    @Override
    public void accept(CardVisitor cardVisitor) {
        cardVisitor.visit(this);
    }
}