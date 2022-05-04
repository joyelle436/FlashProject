package be.ugent.flash.command;

import be.ugent.flash.data.JDBCDataAccessContext;
import be.ugent.flash.data.JDBCDataAccessProvider;
import be.ugent.flash.data.Question;
import be.ugent.flash.viewer.ErrorDisplay;

import java.sql.SQLException;

public class DatabaseUpdater {

    private final JDBCDataAccessContext dataAccessContext;
    public DatabaseUpdater(String database) throws SQLException {
        this.dataAccessContext = new JDBCDataAccessProvider(database).getDataAccessContext();
    }

    public void addNewQuestion(String title, String type) {
        try {
            dataAccessContext.getQuestionDAO().addQuestion(title, type);
        } catch (SQLException e) {
            ErrorDisplay.showAlert(e.getMessage());
        }
    }

    public void deleteQuestion(String title, String type){
        try {
            int question_id = dataAccessContext.getQuestionDAO().getQuestion(title).id();
            dataAccessContext.getPartDAO().deleteParts(question_id);
            dataAccessContext.getQuestionDAO().deleteQuestion(title, type);
        } catch (SQLException e) {
            ErrorDisplay.showAlert(e.getMessage());
        }
    }
    public void updateQuestion(Question question) throws SQLException {
        dataAccessContext.getQuestionDAO().updateQuestion(question);
    }

    public void close() throws SQLException{
        dataAccessContext.close();
    }
}
