package be.ugent.flash.cards;


import be.ugent.flash.data.Part;
import be.ugent.flash.data.Question;
import be.ugent.flash.visitors.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;


/**
 * superklasse voor {@link OpenIntCard} en {@link OpenStrCard}
 */
public class OpenQuestion extends Type implements CardItem<OpenQuestion> {

    protected final TextField answerField;
    protected final Label errorlabel;
    protected OpenQuestion(Stage stage, Question questionRow) {
        super(stage, questionRow);
        this.answerField = new TextField();
        answerField.setId("textfield");
        answerField.setMaxWidth(400);
        this.errorlabel = new Label();
        errorlabel.setVisible(false);
        errorlabel.setFont(new Font(17.5));
        GridPane.setConstraints(answerField, 0, 0);
        GridPane.setConstraints(errorlabel, 0, 1);
    }

    public void clear() {
        super.clear();
        answerField.clear();
        answerField.getStyleClass().removeAll("changeBorder"); /* lukt niet altijd dus v */
        errorlabel.setVisible(false);
    }

    public TextField getAnswerField() {
        return answerField;
    }

    public Label getErrorlabel() {
        return errorlabel;
    }

    public void setAnswers(List<Part> answers){
    }

    @Override
    public void accept(CardVisitor<OpenQuestion> cardVisitor) {
        cardVisitor.visit(this);
    }
}