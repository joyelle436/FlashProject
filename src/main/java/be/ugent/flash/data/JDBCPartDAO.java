package be.ugent.flash.data;

import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
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
                "SELECT part_id, question_id, part FROM parts WHERE question_id=? ORDER BY question_id, part_id;")){
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
    public void updatePart(int part_id, byte[] part, String question_type) throws SQLException{
        try (PreparedStatement preparedStatement = prepare(
                "UPDATE FROM parts SET part=? WHERE part_id=?"
        )){
            preparedStatement.setInt(1, part_id);
            if(question_type.equals("mci")){
                preparedStatement.setBlob(2, (Blob) new Image(new ByteArrayInputStream(part)));
            } else {
                preparedStatement.setString(2, new String(part));
            }
        }
    }

    @Override
    public void addPart(Part part) {

    }
}
