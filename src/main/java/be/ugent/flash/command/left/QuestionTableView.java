package be.ugent.flash.command.left;

import be.ugent.flash.CommandMapMaker;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


import java.util.*;

/**
 * Events wordt door {@link TableViewController} behandeld
 */

public class QuestionTableView extends TableView<TableViewPair> {

    private final TableViewController tableController;
    private final CommandMapMaker mapMaker;
    private final LeftSidePane leftSidePane;
    public QuestionTableView(LeftSidePane leftSidePane){
        this.tableController = new TableViewController(this);
        this.leftSidePane = leftSidePane;
        setMaxSize(500, 670);
        setEditable(true);
        TableColumn<TableViewPair, String> title = new TableColumn<>("Titel");
        title.setCellValueFactory(pairString -> pairString.getValue().titleProperty());
        TableColumn<TableViewPair, String> type = new TableColumn<>("Type");
        type.setCellValueFactory(pairString -> pairString.getValue().typeProperty());
        title.setId("column");
        type.setId("column");
        getColumns().setAll(List.of(title, type));
        setOnMouseClicked(tableController);
        this.mapMaker = new CommandMapMaker();
        mapMaker.makeTypeMap();
        mapMaker.makeswapedQTypeMap();
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public LeftSidePane getLeftSidePane() {
        return leftSidePane;
    }

    public CommandMapMaker getMapMaker() {
        return mapMaker;
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
        /*
        Vraag die zojuist toegevoegd is wordt dan direct geselecteerd
        Bron: https://stackoverflow.com/questions/11552176/generating-a-mouseevent-in-javafx
        */
        Event.fireEvent(this, new MouseEvent(MouseEvent.MOUSE_CLICKED, 0,
                0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true,
                true, true, true, true, true, true, null));
    }

    public void removeSelectedRow() {
        if(getSelectionModel().getSelectedItem() != null){
            leftSidePane.deleteQuestionFromDatabase(getSelectionModel().getSelectedItem().getTitle(),
                    mapMaker.getSwapedStringType(getSelectionModel().getSelectedItem().getType()));
            getItems().remove(getSelectionModel().getSelectedItem());
            leftSidePane.getMainController().getRightController().setLabelToCenter();
        }
    }
}