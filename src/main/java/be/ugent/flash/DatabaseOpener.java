package be.ugent.flash;

import be.ugent.flash.data.Part;
import be.ugent.flash.data.Question;
import be.ugent.flash.viewer.ErrorDisplay;
import javafx.stage.*;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class DatabaseOpener {

    private final Stage stage;
    public DatabaseOpener(Stage stage){
        this.stage = stage;
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
    }
}
