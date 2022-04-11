package be.ugent.flash.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Gebaseerd op code uit de cursus
 */
public class JDBCAbstractDAO {

    private final Connection connection;

    public JDBCAbstractDAO(Connection connection){
        this.connection = connection;
    }

    protected PreparedStatement prepare(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}
