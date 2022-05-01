package be.ugent.flash.command.lefts;

import be.ugent.flash.command.SidePaneConnection;

import java.util.Map;

public class LeftController {

    private final LeftSidePane leftSidePane;
    private final SidePaneConnection mainController;
    public LeftController(SidePaneConnection controller, Map<Integer, String[]> questionMap){
        this.mainController = controller;
        this.leftSidePane = new LeftSidePane(controller);
        leftSidePane.fillLeftPane(questionMap);
    }

    public String getDatabase(){
        return mainController.getDatabase();
    }

    public LeftSidePane getLeftSidePane() {
        return leftSidePane;
    }

    public void disableTable() {
        leftSidePane.getTableView().setDisable(true);
    }

    public void enableTable() {
        leftSidePane.getTableView().setDisable(false);
    }

    public void unselectItems() {
        leftSidePane.getTableView().getSelectionModel().clearSelection();
    }
}
