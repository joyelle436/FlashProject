package be.ugent.flash.handlers;

import be.ugent.flash.command.lefts.LeftSidePane;
import be.ugent.flash.command.lefts.QuestionTableView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * EventHandler voor {@link QuestionTableView}
 */
public class TableViewHandler implements EventHandler<MouseEvent> {
    private LeftSidePane leftSidePane;
    private QuestionTableView questionTableView;
    public TableViewHandler(LeftSidePane leftSidePane, QuestionTableView questionTableView){
        this.leftSidePane = leftSidePane;
        this.questionTableView = questionTableView;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        String title = questionTableView.getSelectionModel().getSelectedItem().getTitle();
        leftSidePane.showQuestionInfo(title);
    }
}
