package be.ugent.flash;

import be.ugent.flash.data.*;

import java.sql.SQLException;
import java.util.List;

public class DataCollector {

    private final JDBCDataAccessContext dataAccessContext;
    public DataCollector(String database) throws SQLException {
        this.dataAccessContext = new JDBCDataAccessProvider(database).getDataAccessContext();
    }

    public List<Question> getQuestionsData() throws SQLException {
        return dataAccessContext.getQuestionDAO().getQuestions();
    }

    public List<Part> getAllPartsData() throws SQLException {
      return dataAccessContext.getPartDAO().getAllParts();
    }

    public List<Part> getPartsData(int question_id) throws SQLException {
        return dataAccessContext.getPartDAO().getParts(question_id);
    }

    public void closeDAC() throws SQLException {
        dataAccessContext.close();
    }
}
