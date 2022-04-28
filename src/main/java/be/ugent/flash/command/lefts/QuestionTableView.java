package be.ugent.flash.command.lefts;

import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.command.QuestionData;
import be.ugent.flash.controllers.TableViewController;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.util.*;


public class QuestionTableView extends TableView<TableViewPair> {

    private final TableColumn<TableViewPair, String> title;
    private final TableColumn<TableViewPair, String> type;
    private final TableViewController tableController;
    private final CommandMapMaker mapMaker;
    public QuestionTableView(LeftSidePane leftSidePane){
        this.tableController = new TableViewController(leftSidePane, this);
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
        getItems().add(new TableViewPair(questionTitle, mapMaker.getStringType(questionType)));
    }
}