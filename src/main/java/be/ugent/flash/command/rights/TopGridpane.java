package be.ugent.flash.command.rights;

import be.ugent.flash.command.QuestionData;
import be.ugent.flash.command.lefts.LeftSidePane;
import be.ugent.flash.command.rights.TopContent;
import javafx.geometry.*;

import javafx.scene.layout.*;

import java.util.Objects;

/**
 * Staat boven de {@link LeftSidePane} rechterkant van de beheersinterface
 */
public class TopGridpane extends GridPane {

    private final TopContent topContent;
    public TopGridpane(){
        this.topContent = new TopContent();
        setAlignment(Pos.TOP_CENTER);
        BorderPane.setMargin(this, new Insets(15));
        setVgap(7);
        setHgap(15);
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public void fillGridpane(){
        topContent.addContent();
        getChildren().addAll(topContent.getTopLabels());
        getChildren().addAll(topContent.getNodeTable());
        getColumnConstraints().addAll(new ColumnConstraints(80), new ColumnConstraints(575));
    }

    public void addToTopContent(QuestionData questionData){
        topContent.setTitleText(questionData.getTitle());
        topContent.setTypeText(questionData.getQuestionType());
        topContent.setQuestionText(questionData.getText());
    }
}