package be.ugent.flash.command.left;

import be.ugent.flash.command.ClickEventSimulator;
import be.ugent.flash.command.CommandMapMaker;
import javafx.scene.control.*;


import java.util.*;

/**
 * Events wordt door {@link TableViewController} behandeld
 */

public class QuestionTableView extends TableView<TableViewPair> {

    private final TableViewController tableController;
    private final CommandMapMaker commandMapMaker;
    private final LeftSidePane leftSidePane;
    public QuestionTableView(LeftSidePane leftSidePane){
        this.tableController = new TableViewController(this);
        this.leftSidePane = leftSidePane;
        setPrefSize(500, 670);
        setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        TableColumn<TableViewPair, String> title = new TableColumn<>("Titel");
        title.setCellValueFactory(pairString -> pairString.getValue().titleProperty());
        TableColumn<TableViewPair, String> type = new TableColumn<>("Type");
        type.setCellValueFactory(pairString -> pairString.getValue().typeProperty());
        title.setId("column");
        type.setId("column");
        getColumns().setAll(List.of(title, type));
        setOnMouseClicked(tableController);
        this.commandMapMaker = new CommandMapMaker();
        commandMapMaker.makeTypeMap();
        commandMapMaker.makeswapedQTypeMap();
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public LeftSidePane getLeftSidePane() {
        return leftSidePane;
    }

    public CommandMapMaker getCommandMapMaker() {
        return commandMapMaker;
    }


    public void addColumnsData(Map<Integer, String[]> questionMap){
        tableController.addColumns(questionMap);
    }

    public void addRow(String questionTitle, String questionType){
        TableViewPair pair = new TableViewPair(questionTitle, questionType);
        getItems().add(pair);
        requestFocus();
        getSelectionModel().select(pair);
        getFocusModel().focus(getItems().indexOf(pair));
        /* Vraag die zojuist toegevoegd is wordt geselecteerd */
        ClickEventSimulator.simulateClickEvent(this);
    }

    public void removeSelectedRow() {
        if(getSelectionModel().getSelectedItem() != null){
            leftSidePane.deleteQuestionFromDatabase(getSelectionModel().getSelectedItem().getTitle(),
                    commandMapMaker.getSwapedStringType(getSelectionModel().getSelectedItem().getType()));
            getItems().remove(getSelectionModel().getSelectedItem());
            leftSidePane.getMainController().getRightController().setLabelToCenter();
        }
    }

    /**
     * Als de titel aan de rechterkant veranderd wordt die dan meteen in de tableView aangepast
     */
    public void updateTableTitle(String title) {
        TableViewPair updatedPair = new TableViewPair(title, getSelectionModel().getSelectedItem().getType());
        getItems().set(getSelectionModel().getSelectedIndex(), updatedPair);
    }
}