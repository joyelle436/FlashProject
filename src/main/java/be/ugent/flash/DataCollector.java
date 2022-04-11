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

    public List<Part> getPartsData() throws SQLException {
      return dataAccessContext.getPartDAO().getParts();
    }

    public void closeDAC() throws SQLException {
        dataAccessContext.close();
    }
}
