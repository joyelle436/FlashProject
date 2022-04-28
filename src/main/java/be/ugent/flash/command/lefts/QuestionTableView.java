package be.ugent.flash.command.lefts;

import be.ugent.flash.command.QuestionData;
import be.ugent.flash.controllers.TableViewController;
import javafx.scene.control.*;


import java.util.*;


public class QuestionTableView extends TableView<TableViewPair> {

    private final TableColumn<TableViewPair, String> title;
    private final TableColumn<TableViewPair, String> type;
    private final TableViewController tableController;
    public QuestionTableView(LeftSidePane leftSidePane){
        this.tableController = new TableViewController(leftSidePane, this);
        setMaxSize(500, 670);
        setEditable(true);
        this.title = new TableColumn<>("Titel");
        this.type = new TableColumn<>("Type");
        title.setId("column");
        type.setId("column");
        setOnMouseClicked(tableController);
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public TableColumn<TableViewPair, String> getTitle(){
        return title;
    }

    public TableColumn<TableViewPair, String> getType(){
        return type;
    }

    public void addColumnsData(List<QuestionData> questionDataList){
        tableController.addColumns(questionDataList);
    }

    public void addRow(String questionTitle, String questionType){
        getItems().add(new TableViewPair(questionTitle, questionType));
    }
}