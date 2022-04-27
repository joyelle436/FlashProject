package be.ugent.flash.command;

import be.ugent.flash.DataCollector;
import be.ugent.flash.data.*;
import javafx.stage.*;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class DatabaseOpener {

    private final Stage stage;
    /*
    Dit gaat de hele tijd getoond worden
     */
    private final MainBorderPane startWindow;
    private String database;
    public DatabaseOpener(MainBorderPane mainBorderPane){
        this.stage = mainBorderPane.getSTAGE();
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
        List<Part> partList = dataCollector.getPartsData(); /* alle gegevens uit parts */
        dataCollector.closeDAC();
        new PaneStarter(startWindow, questionList, partList, database);
    }
}