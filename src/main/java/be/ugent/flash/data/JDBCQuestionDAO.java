package be.ugent.flash.data;

import java.sql.*;
import java.util.*;
/**
 * Gebaseerd op code uit de cursus
 */
public class JDBCQuestionDAO extends JDBCAbstractDAO implements QuestionDAO {

    private final List<Question> questionList;

    public JDBCQuestionDAO(Connection connection) {
        super(connection);
        this.questionList = new ArrayList<>();
    }
    /*
    gegevens uit de <<questions>> tabel
     */
    @Override
    public List<Question> getQuestions() throws SQLException {
        try (PreparedStatement preparedStatement = prepare(
                "SELECT question_id, title, text_part, image_part, " +
                        "question_type, correct_answer FROM questions ORDER BY question_id;")){

            ResultSet questionsResult = preparedStatement.executeQuery();
            while(questionsResult.next()){
                addRow(questionsResult);
            }

        }
        return questionList;
    }

    /**
     * Dit methode krijgt de Result en gaat telkens alle data(uit questions) een per een in een record opslaan
     */
    private void addRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String title = resultSet.getString(2);
        String text = resultSet.getString(3);
        byte[] middleImage = resultSet.getBytes(4);
        String questionType = resultSet.getString(5);
        String correctAnswer = resultSet.getString(6);
        questionList.add(new Question(id, title, text, middleImage, questionType, correctAnswer));
    }
}
