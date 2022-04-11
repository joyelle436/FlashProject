package be.ugent.flash.data;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDataAccessContext implements DataAccessContext {

    private final Connection connection;

    public JDBCDataAccessContext(Connection connection){
        this.connection = connection;
    }
    @Override
    public QuestionDAO getQuestionDAO() {
        return new JDBCQuestionDAO(connection);
    }

    @Override
    public PartDAO getPartDAO() {
        return new JDBCPartDAO(connection);
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
