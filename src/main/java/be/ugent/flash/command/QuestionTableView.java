package be.ugent.flash.command;

import be.ugent.flash.MapMaker;
import be.ugent.flash.data.Question;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.util.*;


public class QuestionTableView extends TableView<Pair> {

    private final TableColumn<Pair, String> title;
    private final TableColumn<Pair, String> type;
    public QuestionTableView(){
        setMaxSize(500, 670);
        this.title = new TableColumn<>("Titel");
        this.type = new TableColumn<>("Type");
        title.setId("column");
        type.setId("column");
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public void addColumnsData(List<Question> questionList){
        List<Pair> pairList = new ArrayList<>();
        MapMaker mapMaker = new MapMaker();
        mapMaker.makeTypeMap();
        for(Question question: questionList){
            pairList.add(new Pair(question.title(), mapMaker.getStringType(question.questionType())));
        }
        setItems(FXCollections.observableArrayList(pairList));
        title.setCellValueFactory(new PropertyValueFactory<>(pairList.get(0).titleProperty().getName()));
        type.setCellValueFactory(new PropertyValueFactory<>(pairList.get(0).typeProperty().getName()));
        getColumns().setAll(List.of(title, type));
    }
}