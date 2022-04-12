package be.ugent.flash.data;

import java.sql.SQLException;
import java.util.List;
/**
 * Gebaseerd op code uit de cursus
 */
public interface QuestionDAO {
    List<Question> getQuestions() throws SQLException;
}
