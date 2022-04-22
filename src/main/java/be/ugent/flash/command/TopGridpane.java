package be.ugent.flash.command;

import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.control.*;

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
        Label[] TOPLABELS = topContent.getTopLabels();
        Node[] NODETABLE = topContent.getNodeTable();
        getChildren().addAll(TOPLABELS);
        getChildren().addAll(NODETABLE);
        for(int index = 0; index < 4; index++){
            GridPane.setConstraints(TOPLABELS[index], 0, index);
            GridPane.setConstraints(NODETABLE[index], 1, index);
            GridPane.setValignment(TOPLABELS[index], VPos.TOP);
            TOPLABELS[index].setStyle("-fx-font-size: 13px");
            NODETABLE[index].setStyle("-fx-font-size: 13px");
        }
        getColumnConstraints().addAll(new ColumnConstraints(80), new ColumnConstraints(575));
    }

    public void addToTopContent(QuestionData questionData){
        topContent.setTitleText(questionData.getTitle());
        topContent.setTypeText(questionData.getQuestionType());
        topContent.setQuestionText(questionData.getText());
    }
}