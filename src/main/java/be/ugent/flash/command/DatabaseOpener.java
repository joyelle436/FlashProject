package be.ugent.flash.command;

import be.ugent.flash.DataCollector;
import be.ugent.flash.data.*;
import be.ugent.flash.viewer.ErrorDisplay;
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
    public DatabaseOpener(Stage stage, MainBorderPane startWindow){
        this.stage = stage;
        this.startWindow = startWindow;
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
                new ErrorDisplay().showAlert(e.getMessage());
            }
        }
    }
    public void getFileData(String database) throws SQLException {
        DataCollector dataCollector = new DataCollector(database);
        List<Question> questionList = dataCollector.getQuestionsData(); /* alle gegevens uit questions */
        List<Part> partList = dataCollector.getPartsData(); /* alle gegevens uit parts */
        dataCollector.closeDAC();
        new PaneOpener(startWindow, questionList, partList).showList();
    }
}