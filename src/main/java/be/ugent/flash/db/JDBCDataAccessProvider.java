package be.ugent.flash.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Gebaseerd op code uit de cursus
 */
public class JDBCDataAccessProvider implements DataAccessProvider {

    private final String DATA;

    public JDBCDataAccessProvider(String database){
        this.DATA = "jdbc:sqlite:" + database;
    }

    @Override
    public JDBCDataAccessContext getDataAccessContext() throws SQLException {
        return new JDBCDataAccessContext(getConnection());
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATA);
    }
}
