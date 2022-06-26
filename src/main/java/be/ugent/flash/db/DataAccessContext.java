package be.ugent.flash.db;

import java.sql.SQLException;

/**
 * Gebaseerd op code uit de cursus
 */
public interface DataAccessContext extends AutoCloseable {
    QuestionDAO getQuestionDAO();
    PartDAO getPartDAO();
    void close() throws SQLException;
}
