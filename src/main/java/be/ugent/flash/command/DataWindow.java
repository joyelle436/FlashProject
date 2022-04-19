package be.ugent.flash.command;

import be.ugent.flash.data.Part;
import be.ugent.flash.data.Question;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.*;

/**
 * Toont vragen types op het venster met behulp van een paar klassen
 */
public class DataWindow extends BorderPane {
    private final Stage stage;
    private final List<Question> questionList;
    private final List<Part> partList;
    public DataWindow(Stage stage, List<Question> questionList, List<Part> partList){
        setId("window");
        this.stage = stage;
        this.questionList = questionList;
        this.partList = partList;
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    /**
     * Voeg de vragen aan de stage toe
     */
    public void addQuestions(){
        new QuestionView(stage, questionList, partList);
    }
}