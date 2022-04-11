package be.ugent.flash;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.sql.*;
import java.util.*;

/**
 * Dit klas gaat bij het begin het databank openen, alle vragen in een record, lijst opslaan
 * en die doorgeven naar een andere klasse {@link Simulator} die de vragen in verschillende klassen gaat verdelen
 */

public class ViewerStarter {

    private final Stage stage;
    private final List<QuestionRow> rows;
    /*
    question_id afgebeeld op <<part_id afgebeeld part>>
     */
    private final Map<Integer, Map<Integer, byte[]>> answers;
    private final String DATA;

    public ViewerStarter(Stage stage, String database) {
        this.stage = stage;
        DATA = "jdbc:sqlite:" + database;
        answers = new HashMap<>();
        rows = new ArrayList<>();
    }

    public void openDatabase(){
        getdata();
    }

    private void getdata(){
        try(Connection connection = DriverManager.getConnection(DATA)){
            try (PreparedStatement prepStatement = connection.prepareStatement(
                    "SELECT question_id, title, text_part, image_part, " +
                            "question_type, correct_answer FROM questions ORDER BY question_id;")){
                ResultSet questionsResult = prepStatement.executeQuery();
                while(questionsResult.next()){
                    addRow(questionsResult);
                }
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT question_id, part_id, part FROM parts ORDER BY question_id, part_id;")){
                ResultSet answersResult = preparedStatement.executeQuery();
                while(answersResult.next()){
                    answers.get(answersResult.getInt(1)).put(answersResult.getInt(2), answersResult.getBytes(3));
                }
            }
            new Simulator(stage, rows, answers).divideQuestions();
        } catch (SQLException e) {
            showAlert();
        }
    }

    /**
     * Dit methode krijgt de Result en gaat telkens alle data(uit questions) een per een in een record opslaan
     */
    private void addRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        answers.put(id, new HashMap<>()); /* bijna elke id heeft eigen antwoorden uit de tabel parts */
        String title = resultSet.getString(2);
        String text = resultSet.getString(3);
        byte[] middleImage = resultSet.getBytes(4);
        String questionType = resultSet.getString(5);
        String correctAnswer = resultSet.getString(6);
        rows.add(new QuestionRow(id, title, text, middleImage, questionType, correctAnswer));
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