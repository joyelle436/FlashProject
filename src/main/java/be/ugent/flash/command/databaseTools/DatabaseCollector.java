package be.ugent.flash.command.databaseTools;

import be.ugent.flash.db.JDBCDataAccessContext;
import be.ugent.flash.db.JDBCDataAccessProvider;
import be.ugent.flash.db.Part;
import be.ugent.flash.db.Question;
import be.ugent.flash.viewer.ErrorDisplay;

import java.sql.SQLException;
import java.util.List;

public class DatabaseCollector {

    private final JDBCDataAccessContext dataAccessContext;
    public DatabaseCollector(String database) throws SQLException {
        this.dataAccessContext = new JDBCDataAccessProvider(database).getDataAccessContext();;
    }
    public Question getQuestionContent(String title) {
        Question question = null;
        try {
            question = dataAccessContext.getQuestionDAO().getQuestion(title);
        } catch (SQLException e) {
            ErrorDisplay.showAlert(e.getMessage());
        }
        return question;
    }

    public List<Part> getPartsContent(int question_id){
        List<Part> parts = null;
        try {
            parts = dataAccessContext.getPartDAO().getParts(question_id);
        } catch (SQLException e){
            ErrorDisplay.showAlert(e.getMessage());
        }
        return parts;
    }
}