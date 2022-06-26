package be.ugent.flash.viewer;

import be.ugent.flash.db.DataCollector;
import be.ugent.flash.db.Part;
import be.ugent.flash.db.Question;
import javafx.stage.Stage;

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
            List<Part> partList = dataCollector.getAllPartsData(); /* alle gegevens uit parts */
            dataCollector.closeDAC();
            new CardsSimulator(stage, questionList, partList).showQuestions();
        } catch (Exception e) {
            ErrorDisplay.showAlert(e.getMessage());
        }
    }
}