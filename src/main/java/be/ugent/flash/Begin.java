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
    private final List<String[]> questions;
    private final Map<String, List<String[]>> answers;
    private final String DATA;

    public Begin(Stage stage, String database) {
        this.stage = stage;
        DATA = "jdbc:sqlite:" + database;
        questions = new ArrayList<>();
        answers = new HashMap<>();
    }

    public void openDatabase() throws IOException {
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
        getAnswers();
        new Spreader(stage, DATA, questions, answers).divideQuestions();
    }

    private void getAnswers(){
        try(Connection connection = DriverManager.getConnection(DATA)){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT part_id, question_id, part FROM parts ORDER BY question_id;"
            );
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                answers.get(result.getString(2)).add(new String[]{result.getString(1), result.getString(3)});
            }
        } catch (SQLException ex){
            System.out.println("het lukt niet om de databank in te lezen");
        }
    }

    /**
     * Dit methode krijgt de Result en gaat telkens alle data van een rij
     * van een rij in een eigen array opslaan
     */
    public void addRow(ResultSet resultSet) throws SQLException {
        String[] row = new String[6];
        for(int r = 1; r <= 6; r++){
            String str = resultSet.getString(r);
            if(r == 1){
                answers.put(str, new ArrayList<>());
            }
            row[r-1] = resultSet.getString(r);
        }
        questions.add(row);
    }
}