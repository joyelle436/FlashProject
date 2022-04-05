package be.ugent.flash.cards;


import be.ugent.flash.visitors.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;

/**
 * superklasse voor OpenIntCard(openi) en OpenStrCard(open)
 */
public class OpenQuestion extends Type implements CardItem<OpenQuestion> {
    protected final TextField answerField;
    protected final Label foutlabel;
    protected OpenQuestion(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, row, answers, nextCard);
        this.answerField = new TextField();
        answerField.setId("textfield");
        answerField.setMaxWidth(400);
        this.foutlabel = new Label();
        foutlabel.setVisible(false);
        foutlabel.setFont(new Font(17.5));
        GridPane.setConstraints(answerField, 0, 0);
        GridPane.setConstraints(foutlabel, 0, 1);
    }

    public TextField getAnswerField() {
        return answerField;
    }

    public Label getFoutlabel() {
        return foutlabel;
    }

    public void handleEvents(){
    }
    @Override
    public void accept(CardVisitor<OpenQuestion> cardVisitor) {
        cardVisitor.visit(this);
    }
}