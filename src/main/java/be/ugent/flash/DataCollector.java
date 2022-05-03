package be.ugent.flash;

import be.ugent.flash.data.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DataCollector {

    private final JDBCDataAccessContext dataAccessContext;
    private final JDBCDataAccessProvider jdbcDataAccessProvider;
    public DataCollector(String database) throws SQLException {
        this.jdbcDataAccessProvider = new JDBCDataAccessProvider(database);
        this.dataAccessContext = jdbcDataAccessProvider.getDataAccessContext();
    }

    public Connection getDatabaseConnection() throws SQLException {
        return jdbcDataAccessProvider.getConnection();
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
