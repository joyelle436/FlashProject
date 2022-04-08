package be.ugent.flash;

import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * Dit klas gaat bij het begin het databank openen, alle vragen in een lijst opslaan
 * en die lijst doorgeven naar een andere klasse {@link Simulator} die de vragen gaat verdelen
 */

public class Begin {

    private final Stage stage;
    private final List<QuestionRow> rows;
    //question afgebeeld of part id die afgebeeld is op die part
    private final Map<Integer, Map<Integer, byte[]>> answers;
    private final String DATA;

    public Begin(Stage stage, String database) {
        this.stage = stage;
        DATA = "jdbc:sqlite:" + database;
        answers = new HashMap<>();
        rows = new ArrayList<>();
    }

    public void openDatabase() throws IOException {
        getQuestions();
        new Simulator(stage, rows, answers).divideQuestions();
    }

    private void getQuestions(){
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
                    "SELECT part_id, question_id, part FROM parts ORDER BY question_id;")){
                ResultSet answersResult = preparedStatement.executeQuery();
                while(answersResult.next()){
                    answers.get(answersResult.getInt(2)).put(answersResult.getInt(1), answersResult.getBytes(3));
                }
            }
        } catch (SQLException ex){
            System.out.println("het lukt niet om de databank in te lezen");
        }
    }

    /**
     * Dit methode krijgt de Result en gaat telkens alle data(uit questions) een per een in een record opslaan
     */
    private void addRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        answers.put(id, new HashMap<>()); // elke id heeft eigen antwoorden uit de tabel parts
        String title = resultSet.getString(2);
        String text = resultSet.getString(3);
        byte[] middleImage = resultSet.getBytes(4);
        String questionType = resultSet.getString(5);
        String correctAnswer = resultSet.getString(6);
        rows.add(new QuestionRow(id, title, text, middleImage, questionType, correctAnswer));
    }
}