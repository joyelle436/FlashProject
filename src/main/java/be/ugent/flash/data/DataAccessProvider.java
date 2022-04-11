package be.ugent.flash.data;

import java.sql.SQLException;

/**
 * Gebaseerd op code uit de cursus
 */
public interface DataAccessProvider {
    DataAccessContext getDataAccessContext() throws SQLException;
}
