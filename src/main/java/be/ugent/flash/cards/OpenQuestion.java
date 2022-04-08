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
    protected final Label errorlabel;
    protected OpenQuestion(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers) {
        super(stage, questionRow, answers);
        this.answerField = new TextField();
        answerField.setId("textfield");
        answerField.setMaxWidth(400);
        this.errorlabel = new Label();
        errorlabel.setVisible(false);
        errorlabel.setFont(new Font(17.5));
        GridPane.setConstraints(answerField, 0, 0);
        GridPane.setConstraints(errorlabel, 0, 1);
    }

    public void setModel(CardModel model){
    }

    @Override
    public void clear() {
        answerField.clear();
        errorlabel.setVisible(false);
        answerField.getStyleClass().remove("changeBorder");
        errorlabel.getStyleClass().remove("changeText");
    }

    public TextField getAnswerField() {
        return answerField;
    }

    public Label getErrorlabel() {
        return errorlabel;
    }

    public void handleEvents(){
    }
    @Override
    public void accept(CardVisitor<OpenQuestion> cardVisitor) {
        cardVisitor.visit(this);
    }
}