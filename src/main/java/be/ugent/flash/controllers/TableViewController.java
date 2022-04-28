package be.ugent.flash.controllers;

import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.command.lefts.*;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.*;

/**
 * EventHandler voor {@link QuestionTableView}
 */
public class TableViewController implements EventHandler<MouseEvent> {
    private final LeftSidePane leftSidePane;
    private final QuestionTableView questionTableView;
    public TableViewController(LeftSidePane leftSidePane, QuestionTableView questionTableView){
        this.leftSidePane = leftSidePane;
        this.questionTableView = questionTableView;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        if(questionTableView.getSelectionModel().getSelectedItem() != null){
            String title = questionTableView.getSelectionModel().getSelectedItem().getTitle();
            String type = questionTableView.getSelectionModel().getSelectedItem().getType();
            leftSidePane.showQuestionInfo(title, questionTableView.getMapMaker().getSwapedStringType(type));
        }
    }

    public void addColumns(Map<Integer, String[]> questionMap) {
        List<TableViewPair> pairList = new ArrayList<>();
        CommandMapMaker mapMaker = new CommandMapMaker();
        mapMaker.makeTypeMap();
        for(int key: questionMap.keySet()){
            pairList.add(new TableViewPair(questionMap.get(key)[0], mapMaker.getStringType(questionMap.get(key)[1])));
        }
        questionTableView.setItems(FXCollections.observableArrayList(pairList));
        questionTableView.getTitle().setCellValueFactory(new PropertyValueFactory<>(pairList.get(0).titleProperty().getName()));
        questionTableView.getType().setCellValueFactory(new PropertyValueFactory<>(pairList.get(0).typeProperty().getName()));
        questionTableView.getColumns().setAll(List.of(questionTableView.getTitle(), questionTableView.getType()));
    }
}