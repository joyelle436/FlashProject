package be.ugent.flash.command.left;

import be.ugent.flash.CommandMapMaker;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.*;

/**
 * EventHandler voor {@link QuestionTableView}
 */
public class TableViewController implements EventHandler<MouseEvent> {

    private final QuestionTableView questionTableView;

    public TableViewController(QuestionTableView questionTableView) {
        this.questionTableView = questionTableView;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (questionTableView.getSelectionModel().getSelectedItem() != null) {
            String title = questionTableView.getSelectionModel().getSelectedItem().getTitle();
            String type = questionTableView.getSelectionModel().getSelectedItem().getType();
            questionTableView.getLeftSidePane().showQuestionInfo(title, questionTableView.getMapMaker().getSwapedStringType(type));
        }
    }

    /**
     * Krijgt een Map met als key een question_id afgebeeld op zijn {title, question_type}
     */
    public void addColumns(Map<Integer, String[]> questionMap) {
        List<TableViewPair> pairList = new ArrayList<>();
        CommandMapMaker mapMaker = new CommandMapMaker();
        mapMaker.makeTypeMap();
        for (int key : questionMap.keySet()) {
            pairList.add(new TableViewPair(questionMap.get(key)[0], mapMaker.getStringType(questionMap.get(key)[1])));
        }
        questionTableView.setItems(FXCollections.observableArrayList(pairList));
    }
}