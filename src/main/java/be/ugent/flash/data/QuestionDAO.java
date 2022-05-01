package be.ugent.flash.data;

import java.sql.SQLException;
import java.util.List;
/**
 * Gebaseerd op code uit de cursus
 */
public interface QuestionDAO {
    List<Question> getQuestions() throws SQLException;
    Question getQuestion(String title) throws SQLException;
    void updateQuestion(int question_id, Question question) throws SQLException;
    void addQuestion(String title, String type) throws SQLException;
    void deleteQuestion(String title, String type) throws SQLException;
}
