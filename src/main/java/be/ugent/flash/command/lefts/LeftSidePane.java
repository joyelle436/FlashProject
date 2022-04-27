package be.ugent.flash.command.lefts;

import be.ugent.flash.command.QuestionData;
import be.ugent.flash.command.SidePaneConnnection;
import javafx.geometry.*;
import javafx.scene.layout.*;

import java.util.*;

/**
 * linkerkant van de beheersinterface
 */
public class LeftSidePane extends GridPane {

    private final QuestionTableView tableView;
    private final SidePaneConnnection controller;
    public LeftSidePane(SidePaneConnnection controller){
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

    public void showQuestionInfo(String title){
        controller.showQuestionContent(title);
    }

    public QuestionTableView getTableView() {
        return tableView;
    }

    public void addToTableView(String questionType){
        tableView.addRow(questionType);
    }

    public void fillLeftPane(List<QuestionData> questionDataList){
        tableView.addColumnsData(questionDataList);
    }

}