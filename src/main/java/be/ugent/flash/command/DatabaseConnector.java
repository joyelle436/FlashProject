package be.ugent.flash.command;

import be.ugent.flash.data.JDBCDataAccessContext;
import be.ugent.flash.data.JDBCDataAccessProvider;
import be.ugent.flash.data.Part;
import be.ugent.flash.data.Question;
import be.ugent.flash.viewer.ErrorDisplay;

import java.sql.SQLException;
import java.util.List;

public class DatabaseConnector {

    private final JDBCDataAccessContext dataAccessContext;
    public DatabaseConnector(String database) throws SQLException {
        this.dataAccessContext = new JDBCDataAccessProvider(database).getDataAccessContext();;
    }

    public Question getQuestionContent(String title) {
        Question question = null;
        try {
            question = dataAccessContext.getQuestionDAO().getQuestion(title);
        } catch (SQLException e) {
            new ErrorDisplay().showAlert(e.getMessage());
        }
        return question;
    }

    public List<Part> getPartsContent(int question_id){
        List<Part> parts = null;
        try {
            parts = dataAccessContext.getPartDAO().getParts(question_id);
        } catch (SQLException e){
            new ErrorDisplay().showAlert(e.getMessage());
        }
        return parts;
    }

    public void close(){
        try {
            dataAccessContext.close();
        } catch (SQLException e) {
            new ErrorDisplay().showAlert(e.getMessage());
        }
    }
}
