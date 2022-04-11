package be.ugent.flash.data;

import java.sql.*;
import java.util.*;
/**
 * Gebaseerd op code uit de cursus
 */
public class JDBCPartDAO extends JDBCAbstractDAO implements PartDAO {

    private final List<Part> partList;
    public JDBCPartDAO(Connection connection) {
        super(connection);
        this.partList = new ArrayList<>();
    }

    @Override
    public List<Part> getParts() throws SQLException {
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
}
