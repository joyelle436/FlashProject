package be.ugent.flash;

import be.ugent.flash.data.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.*;

/**
 * Dit klas gaat bij het begin het databank openen, alle vragen in een record, lijst opslaan
 * en die doorgeven naar een andere klasse {@link Simulator} die de vragen in verschillende klassen gaat verdelen
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
        try {
            dataCollector = new DataCollector(database);
            List<Question>questionList = dataCollector.getQuestionsData();
            List<Part> partList = dataCollector.getPartsData();
            dataCollector.closeDAC();
            new Simulator(stage, questionList, partList).showQuestions();
        } catch (SQLException e) {
            showAlert();
        }
    }

    private void showAlert(){
        Alert alert = new Alert(Alert.AlertType.NONE);
        ButtonType buttonType = new ButtonType("OK");
        alert.getButtonTypes().add(buttonType);
        alert.setTitle("DATABASE ERROR");
        alert.setContentText("Databank bestaat niet of kan niet geopend worden.");
        alert.show();
    }
}