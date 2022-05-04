package be.ugent.flash.data;


import java.sql.*;
import java.util.*;
/**
 * Gebaseerd op code uit de cursus
 */
public class JDBCPartDAO extends JDBCAbstractDAO implements PartDAO {

    public JDBCPartDAO(Connection connection) {
        super(connection);
    }
    /*
    gegevens uit de <<parts>> tabel
     */
    @Override
    public List<Part> getAllParts() throws SQLException {
        List<Part> partList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepare(
                "SELECT question_id, part_id, part FROM parts ORDER BY question_id, part_id;")){
            ResultSet answersResult = preparedStatement.executeQuery();
            while(answersResult.next()){
                partList.add(new Part(answersResult.getInt(1),
                        answersResult.getInt(2), answersResult.getBytes(3)));
            }
        }
        return partList;
    }

    @Override
    public List<Part> getParts(int question_id) throws SQLException {
        List<Part> questionPartsList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepare(
                "SELECT question_id, part_id, part FROM parts WHERE question_id=? ORDER BY question_id, part_id;")){
            preparedStatement.setInt(1, question_id);
            ResultSet answersResult = preparedStatement.executeQuery();
            while(answersResult.next()){
                questionPartsList.add(new Part(answersResult.getInt(1),
                        answersResult.getInt(2), answersResult.getBytes(3)));
            }
        }
        return questionPartsList;
    }

    @Override
    public void updatePart(int question_id, int part_id, byte[] part) throws SQLException{
        try (PreparedStatement preparedStatement = prepare(
                "UPDATE parts SET part=? WHERE question_id=? AND part_id=?"
        )){
            preparedStatement.setBytes(1, part);
            preparedStatement.setInt(2, question_id);
            preparedStatement.setInt(3, part_id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void addPart(int question_id, byte[] part) throws SQLException {
        try (PreparedStatement preparedStatement = prepare(
                "INSERT INTO parts(question_id, part) VALUES(?,?)"
        )){
            preparedStatement.setInt(1, question_id);
            preparedStatement.setBytes(2, part);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deletePart(int part_id) throws SQLException {
        try (PreparedStatement preparedStatement = prepare(
                "DELETE FROM parts WHERE part_id=?"
        )){
            preparedStatement.setInt(1, part_id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteParts(int question_id) throws SQLException {
        try (PreparedStatement preparedStatement = prepare(
          "DELETE FROM parts WHERE question_id=?"
        )){
           preparedStatement.setInt(1, question_id);
           preparedStatement.executeUpdate();
        }
    }
}
