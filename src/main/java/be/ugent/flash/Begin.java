package be.ugent.flash;

import javafx.stage.Stage;

import java.sql.*;
import java.util.*;

/**
 * Dit klas gaat bij het begin het databank openen, alle vragen
 * in een lijst opslaan en die lijst doorgeven naar een andere klasse: Type
 * die de volgende stap gaat doen
 */

public class Begin {

    private final Stage stage;
    private final List<String[]> questions;
    private String DATA;

    public Begin(Stage stage, String database) {
        this.stage = stage;
        DATA = "jdbc:sqlite:" + database;
        questions = new ArrayList<>();
    }

    public void openDatabase() {
        try(Connection connection = DriverManager.getConnection(DATA)){
            PreparedStatement prepStatement = connection.prepareStatement(
                "SELECT * FROM questions ORDER BY question_id;"
            );
            ResultSet result = prepStatement.executeQuery();
            while(result.next()){
                addRow(result);
            }
        } catch (SQLException ex){
            //
        }
        for (String[] q: questions) {
            System.out.println(q[4]);
        }
    }

    /**
     * Dit methode krijgt de Result en gaat telkens alle data van een rij
     * van een rij in een eigen array opslaan
     */
    public void addRow(ResultSet resultSet) throws SQLException {
        String[] row = new String[6];
        for(int r = 1; r <= 6; r++){
            row[r-1] = resultSet.getString(r);
        }
        questions.add(row);
    }
}