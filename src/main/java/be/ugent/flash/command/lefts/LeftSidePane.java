package be.ugent.flash.command.lefts;

import be.ugent.flash.command.QuestionData;
import be.ugent.flash.command.SidePaneConnection;
import javafx.geometry.*;
import javafx.scene.layout.*;

import java.util.*;

/**
 * linkerkant van de beheersinterface
 */
public class LeftSidePane extends GridPane {

    private final QuestionTableView tableView;
    private final SidePaneConnection controller;
    public LeftSidePane(SidePaneConnection controller){
        this.controller = controller;
        setMaxHeight(715);
        this.tableView = new QuestionTableView(this);
        HBox hBox = new HBox();
        hBox.setMaxWidth(500);
        hBox.getChildren().addAll(new LeftBottomButton.AddQuestionButton(this),
                new LeftBottomButton.DeleteQuestionButton(this));
        hBox.setAlignment(Pos.CENTER_RIGHT);
        setMargin(hBox, new Insets(0, 10, 0, 0));
        setMargin(tableView, new Insets(0, 0, 0, 5));
        getRowConstraints().add(new RowConstraints(tableView.getMaxHeight()));
        GridPane.setConstraints(tableView, 0, 0);
        GridPane.setConstraints(hBox, 0, 1);
        getColumnConstraints().add(new ColumnConstraints(500));
        getChildren().addAll(tableView, hBox);
        setVgap(10);
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public void showQuestionInfo(String title, String type){
        controller.showQuestionContent(title, type);
    }

    public void addQuestionToList(QuestionData questionData){
        controller.addQuestion(questionData);
    }

    public QuestionTableView getTableView() {
        return tableView;
    }

    public void fillLeftPane(Map<Integer, String[]> questionMap){
        tableView.addColumnsData(questionMap);
    }

}