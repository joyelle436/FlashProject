package be.ugent.flash;

import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * Dit klas gaat bij het begin het databank openen, alle vragen
 * in een lijst opslaan en die lijst doorgeven naar een andere
 * klasse: Spreader die de volgende stap gaat doen
 */

public class Begin {

    private final Stage stage;
    private final List<List<byte[]>> questions;
    //question afgebeeld of part id die afgebeeld is op die part
    private final Map<Integer, Map<Integer, byte[]>> answers;
    private final String DATA;

    public Begin(Stage stage, String database) {
        this.stage = stage;
        DATA = "jdbc:sqlite:" + database;
        questions = new ArrayList<>();
        answers = new HashMap<>();
    }

    public void openDatabase() throws IOException {
        getQuestions();
        getAnswers();
        new Spreader(stage, questions, answers).divideQuestions();
    }

    private void getQuestions(){
        try(Connection connection = DriverManager.getConnection(DATA)){
            PreparedStatement prepStatement = connection.prepareStatement(
                    "SELECT question_id, title, text_part, image_part, " +
                            "question_type, correct_answer FROM questions ORDER BY question_id;"
            );
            ResultSet result = prepStatement.executeQuery();
            while(result.next()){
                addRow(result);
            }
        } catch (SQLException ex){
            System.out.println("het lukt niet om de databank in te lezen");
        }
    }

    private void getAnswers(){
        try(Connection connection = DriverManager.getConnection(DATA)){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT part_id, question_id, part FROM parts ORDER BY question_id;"
            );
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                answers.get(result.getInt(2)).put(result.getInt(1), result.getBytes(3));
            }
        } catch (SQLException ex){
            System.out.println("het lukt niet om de databank in te lezen");
        }
    }
    /**
     * Dit methode krijgt de Result en gaat telkens alle data van een rij
     * van een rij in een eigen array opslaan
     */
    private void addRow(ResultSet resultSet) throws SQLException {
        List<byte[]> row = new ArrayList<>();
        answers.put(resultSet.getInt(1), new HashMap<>());
        for(int r = 1; r <= 6; r++){
            //getBytes omdat er verschillende types zijn
            row.add(resultSet.getBytes(r));
        }
        questions.add(row);
    }
}