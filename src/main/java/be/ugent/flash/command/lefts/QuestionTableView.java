package be.ugent.flash.command.lefts;

import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.command.TableViewController;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


import java.util.*;

/**
 * Events wordt door {@link TableViewController} behandeld
 */

public class QuestionTableView extends TableView<TableViewPair> {

    private final TableColumn<TableViewPair, String> title;
    private final TableColumn<TableViewPair, String> type;
    private final TableViewController tableController;
    private final CommandMapMaker mapMaker;
    private final LeftSidePane leftSidePane;
    public QuestionTableView(LeftSidePane leftSidePane){
        this.tableController = new TableViewController(this);
        this.leftSidePane = leftSidePane;
        setMaxSize(500, 670);
        setEditable(true);
        this.title = new TableColumn<>("Titel");
        this.type = new TableColumn<>("Type");
        title.setId("column");
        type.setId("column");
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

    public TableColumn<TableViewPair, String> getTitle(){
        return title;
    }

    public TableColumn<TableViewPair, String> getType(){
        return type;
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
        Bron: https://stackoverflow.com/questions/11552176/generating-a-mouseevent-in-javafx
        */
        Event.fireEvent(this, new MouseEvent(MouseEvent.MOUSE_CLICKED, 0,
                0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true,
                true, true, true, true, true, true, null));
    }

    public void removeSelectedRow() {
        leftSidePane.deleteQuestionFromDatabase(getSelectionModel().getSelectedItem().getTitle(),
                mapMaker.getSwapedStringType(getSelectionModel().getSelectedItem().getType()));
        getItems().remove(getSelectionModel().getSelectedItem());
        leftSidePane.getMainController().getRightController().setLabelToCenter();
    }
}