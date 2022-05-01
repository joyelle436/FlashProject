package be.ugent.flash.command;

import be.ugent.flash.data.JDBCDataAccessContext;
import be.ugent.flash.data.JDBCDataAccessProvider;
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
            new ErrorDisplay().showAlert(e.getMessage());
        }
    }

    public void deleteQuestion(String title, String type){
        try {
            dataAccessContext.getQuestionDAO().deleteQuestion(title, type);
        } catch (SQLException e) {
            new ErrorDisplay().showAlert(e.getMessage());
        }
    }
    public void updateQuestion(QuestionData questionData) {
    }
}
