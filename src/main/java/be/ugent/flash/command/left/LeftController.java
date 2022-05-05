package be.ugent.flash.command.left;

import be.ugent.flash.command.SidePaneConnection;

import java.util.Map;

public class LeftController {

    private final LeftSidePane leftSidePane;
    public LeftController(SidePaneConnection controller, Map<Integer, String[]> questionMap){
        this.leftSidePane = new LeftSidePane(controller);
        leftSidePane.fillLeftPane(questionMap);
    }

    public LeftSidePane getLeftSidePane() {
        return leftSidePane;
    }

    public void disableTable() {
        leftSidePane.getTableView().setDisable(true);
        leftSidePane.getAddQuestionButton().setDisable(true);
        leftSidePane.getDeleteQuestionButton().setDisable(true);
    }

    public void enableTable() {
        leftSidePane.getTableView().setDisable(false);
        leftSidePane.getAddQuestionButton().setDisable(false);
        leftSidePane.getDeleteQuestionButton().setDisable(false);
    }

    public void unselectItems() {
        leftSidePane.getTableView().getSelectionModel().clearSelection();
    }
}
