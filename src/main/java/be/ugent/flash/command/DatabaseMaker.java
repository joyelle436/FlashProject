package be.ugent.flash.command;

import be.ugent.flash.DataCollector;
import be.ugent.flash.data.Question;
import be.ugent.flash.db.CreateTables;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseMaker {

    private final MainBorderPane startWindow;
    private final Stage stage;
    public DatabaseMaker(MainBorderPane startWindow){
        this.stage = startWindow.getStage();
        this.startWindow = startWindow;
    }
    public void createFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "Text Files", "*.sqlite"
        ));
        File databaseFile = fileChooser.showSaveDialog(stage);
        if(databaseFile.getName().endsWith(".sqlite")){
            addTables(databaseFile.getPath());
        }
    }

    public void addTables(String database){
        try {
            getFileData(database);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getFileData(String database) throws SQLException {
        DataCollector dataCollector = new DataCollector(database);
        Connection connection = dataCollector.getDatabaseConnection();
        CreateTables.createQuestionsTable(connection);
        CreateTables.createPartsTable(connection);
        List<Question> questionList = dataCollector.getQuestionsData(); /* alle gegevens uit questions */
        Map<Integer, String[]> questionMap = new HashMap<>();
        for(Question question: questionList){
            questionMap.put(question.id(), new String[]{question.title(), question.questionType()});
        }
        dataCollector.closeDAC();
        new PaneStarter(startWindow, questionMap, database, stage);
    }
}
