package be.ugent.flash.cards;


import be.ugent.flash.QuestionRow;
import be.ugent.flash.visitors.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;

/**
 * superklasse voor {@link OpenIntCard} en {@link OpenStrCard}
 */
public class OpenQuestion extends Type implements CardItem<OpenQuestion> {

    protected final TextField answerField;
    protected final Label foutlabel;
    protected OpenQuestion(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, questionRow, answers, nextCard);
        this.answerField = new TextField();
        answerField.setId("textfield");
        answerField.setMaxWidth(400);
        this.foutlabel = new Label();
        foutlabel.setVisible(false);
        foutlabel.setFont(new Font(17.5));
        GridPane.setConstraints(answerField, 0, 0);
        GridPane.setConstraints(foutlabel, 0, 1);
    }

    @Override
    public void clear() {
        answerField.clear();
        foutlabel.setVisible(false);
        answerField.getStyleClass().remove("changeBorder");
        foutlabel.getStyleClass().remove("changeText");
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