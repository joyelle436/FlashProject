package be.ugent.flash.db;

import java.sql.SQLException;

/**
 * Gebaseerd op code uit de cursus
 */
public interface DataAccessProvider {
    DataAccessContext getDataAccessContext() throws SQLException;
}
