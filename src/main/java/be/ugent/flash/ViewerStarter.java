package be.ugent.flash;

import be.ugent.flash.data.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.*;

/**
 *
 */

public class ViewerStarter {

    private final Stage stage;
    private final String database;

    public ViewerStarter(Stage stage, String database) {
        this.stage = stage;
        this.database = database;
    }

    public void openViewer(){
        DataCollector dataCollector;
        /* Ik neem alle gegevens in ene keer op */
        try {
            dataCollector = new DataCollector(database);
            List<Question>questionList = dataCollector.getQuestionsData(); /* alle gegevens uit questions */
            List<Part> partList = dataCollector.getPartsData(); /* alle gegevens uit parts */
            dataCollector.closeDAC();
            new Simulator(stage, questionList, partList).showQuestions();
        } catch (Exception e) {
            new ErrorDisplay().showAlert(e.getMessage());
        }
    }
}