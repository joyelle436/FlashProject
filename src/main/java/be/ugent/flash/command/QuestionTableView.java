package be.ugent.flash.command;

import be.ugent.flash.CommandMapMaker;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.util.*;


public class QuestionTableView extends TableView<TableViewPair> implements EventHandler<MouseEvent> {

    private final TableColumn<TableViewPair, String> title;
    private final TableColumn<TableViewPair, String> type;
    private final LeftSidePane leftSidePane;
    public QuestionTableView(LeftSidePane leftSidePane){
        this.leftSidePane = leftSidePane;
        setMaxSize(500, 670);
        this.title = new TableColumn<>("Titel");
        this.type = new TableColumn<>("Type");
        title.setId("column");
        type.setId("column");
        setOnMouseClicked(this);
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public void addColumnsData(List<QuestionData> questionData){
        List<TableViewPair> pairList = new ArrayList<>();
        CommandMapMaker mapMaker = new CommandMapMaker();
        mapMaker.makeTypeMap();
        for(QuestionData question: questionData){
            pairList.add(new TableViewPair(question.getTitle(), mapMaker.getStringType(question.getQuestionType())));
        }
        setItems(FXCollections.observableArrayList(pairList));
        title.setCellValueFactory(new PropertyValueFactory<>(pairList.get(0).titleProperty().getName()));
        type.setCellValueFactory(new PropertyValueFactory<>(pairList.get(0).typeProperty().getName()));
        getColumns().setAll(List.of(title, type));
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        String title = getSelectionModel().getSelectedItem().getTitle();
        leftSidePane.showALlParts(title);
    }
}