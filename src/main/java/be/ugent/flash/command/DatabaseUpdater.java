package be.ugent.flash.command;

import be.ugent.flash.data.*;
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

    public void addNewPart(int question_id, byte[] part) throws SQLException{
        dataAccessContext.getPartDAO().addPart(question_id, part);
    }

    public void updatePart(int question_id, int part_id, byte[] part) throws SQLException{
        dataAccessContext.getPartDAO().updatePart(question_id, part_id, part);
    }


    public void deletePart(int part_id) throws SQLException{
        dataAccessContext.getPartDAO().deletePart(part_id);
    }

    public void close() throws SQLException{
        dataAccessContext.close();
    }
}