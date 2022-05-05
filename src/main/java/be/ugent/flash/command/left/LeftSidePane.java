package be.ugent.flash.command.left;

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
    private final LeftBottomButton.AddQuestionButton addQuestionButton;
    private final LeftBottomButton.DeleteQuestionButton deleteQuestionButton;
    public LeftSidePane(SidePaneConnection controller){
        this.controller = controller;
        setMaxHeight(715);
        this.tableView = new QuestionTableView(this);
        this.addQuestionButton = new LeftBottomButton.AddQuestionButton(this);
        this.deleteQuestionButton = new LeftBottomButton.DeleteQuestionButton(this);
        HBox hBox = new HBox();
        hBox.setMaxWidth(500);
        hBox.getChildren().addAll(addQuestionButton, deleteQuestionButton);
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

    public SidePaneConnection getMainController() {
        return controller;
    }

    public LeftBottomButton.AddQuestionButton getAddQuestionButton() {
        return addQuestionButton;
    }

    public LeftBottomButton.DeleteQuestionButton getDeleteQuestionButton() {
        return deleteQuestionButton;
    }

    public void showQuestionInfo(String title, String type){
        controller.showQuestionContent(title, type);
    }

    /* Als er een nieuwe vraag toegevoegd wordt */
    public void addQuestionToDatabase(String title, String type){
        controller.addQuestion(title, type);
    }

    public QuestionTableView getTableView() {
        return tableView;
    }

    public void fillLeftPane(Map<Integer, String[]> questionMap){
        tableView.addColumnsData(questionMap);
    }

    public void deleteQuestionFromDatabase(String title, String type) {
        controller.deleteQuestion(title, type);
    }
}