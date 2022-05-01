package be.ugent.flash.command;

import be.ugent.flash.DataCollector;
import be.ugent.flash.data.*;
import javafx.stage.*;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseOpener {

    private final Stage stage;
    /*
    Dit gaat de hele tijd getoond worden
     */
    private final MainBorderPane startWindow;
    private String database;
    public DatabaseOpener(MainBorderPane mainBorderPane){
        this.stage = mainBorderPane.getStage();
        this.startWindow = mainBorderPane;
    }
    public void getFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "Text Files", "*.sqlite"
        ));
        File databaseFile = fileChooser.showOpenDialog(stage);
        if(databaseFile != null){
            try {
                getFileData(databaseFile.getPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void getFileData(String database) throws SQLException {
        this.database = database;
        DataCollector dataCollector = new DataCollector(database);
        List<Question> questionList = dataCollector.getQuestionsData(); /* alle gegevens uit questions */
        Map<Integer, String[]> questionMap = new HashMap<>();
        for(Question question: questionList){
            questionMap.put(question.id(), new String[]{question.title(), question.questionType()});
        }

        dataCollector.closeDAC();
        new PaneStarter(startWindow, questionMap, database);
    }
}