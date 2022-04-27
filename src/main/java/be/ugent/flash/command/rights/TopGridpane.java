package be.ugent.flash.command.rights;

import be.ugent.flash.command.QuestionData;
import be.ugent.flash.command.lefts.LeftSidePane;
import javafx.geometry.*;

import javafx.scene.layout.*;

import java.util.Objects;

/**
 * Staat boven de {@link LeftSidePane} rechterkant van de beheersinterface
 */
public class TopGridpane extends GridPane {

    private QuestionData questionData;
    private TopContent topContent;
    public TopGridpane(){
        setAlignment(Pos.TOP_CENTER);
        BorderPane.setMargin(this, new Insets(15));
        setVgap(7);
        setHgap(15);
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public void fillGridpaneTop(){
        topContent = new TopContent(this);
        topContent.addContent();
        getChildren().addAll(topContent.getTopLabels());
        getChildren().addAll(topContent.getNodeTable());
        getColumnConstraints().addAll(new ColumnConstraints(80), new ColumnConstraints(575));
    }

    public void addToTopContent(QuestionData questionData){
        clearTopGridPane();
        fillGridpaneTop(); /* nieuwe TopContent aanmaken voor elke type vraag */
        this.questionData = questionData;
        topContent.setTitleText(questionData.getTitle());
        questionData.bindTitle(topContent.getTitleField());
        topContent.setTypeText(questionData.getQuestionType());
        topContent.setQuestionText(questionData.getText());
        questionData.bindText(topContent.getTextArea());
    }

    public QuestionData getQuestionData() {
        return questionData;
    }

    public void clearTopGridPane(){
        getChildren().clear();
        getColumnConstraints().clear();
    }
}