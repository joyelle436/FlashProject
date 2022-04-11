package be.ugent.flash.data;

import java.sql.SQLException;
import java.util.List;

public interface QuestionDAO {
    List<Question> getQuestions() throws SQLException;
}
