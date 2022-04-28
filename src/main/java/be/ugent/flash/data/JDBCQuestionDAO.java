package be.ugent.flash.data;

import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
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
                        "question_type, correct_answer FROM questions ORDER BY question_id")){

            ResultSet questionsResult = preparedStatement.executeQuery();
            while(questionsResult.next()){
                addRow(questionsResult);
            }

        }
        return questionList;
    }

    @Override
    public Question getQuestion(String title) throws SQLException{
        Question question = null;
        try (PreparedStatement preparedStatement = prepare(
                "SELECT question_id, title, text_part, image_part, " +
                        "question_type, correct_answer FROM questions WHERE title=?")){

            preparedStatement.setString(1, title);
            ResultSet questionsResult = preparedStatement.executeQuery();
            while(questionsResult.next()){
                question = new Question(questionsResult.getInt(1), questionsResult.getString(2)
                        , questionsResult.getString(3), questionsResult.getBytes(4),
                        questionsResult.getString(5), questionsResult.getString(6));
            }

        }
        return question;
    }


    @Override
    public void updateQuestion(int question_id, Question question) throws SQLException {
        updateTitle(question_id, question.title());
        updateText(question_id, question.text());
        updateImage(question_id, new Image(new ByteArrayInputStream(question.middleImage())));
        updateCorrect(question_id, question.correctAnswer());
    }

    @Override
    public void addQuestion(Question question) throws SQLException {
        try(PreparedStatement preparedStatement = prepare(
                "INSERT INTO questions(question_id, title, text_part, image_part, question_type, correct_answer) " +
                        "VALUES(?, ?, ?, ?, ?, ?)"
        )){
            preparedStatement.setInt(1, question.id());
            preparedStatement.setString(2, question.title());
            preparedStatement.setString(3, question.text());
            preparedStatement.setBlob(4, (Blob) new Image(new ByteArrayInputStream(question.middleImage())));
            preparedStatement.setString(5, question.questionType());
            preparedStatement.setString(6, question.correctAnswer());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteQuestion(int question_id) throws SQLException{
        try(PreparedStatement preparedStatement = prepare(
                "DELETE FROM questions WHERE question_id=?"
        )){
            preparedStatement.setInt(1, question_id);
            preparedStatement.executeUpdate();
        }
    }

    private void updateTitle(int question_id, String title) throws SQLException {
        try (PreparedStatement preparedStatement = prepare(
                "UPDATE FROM questions SET title=? WHERE question_id=?"
        )){
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, question_id);
        }
    }

    private void updateText(int question_id, String text) throws SQLException{
        try (PreparedStatement preparedStatement = prepare(
                "UPDATE FROM questions SET text_part=? WHERE question_id=?"
        )){
            preparedStatement.setString(1, text);
            preparedStatement.setInt(2, question_id);
        }
    }

    private void updateImage(int question_id, Image image) throws SQLException{
        try (PreparedStatement preparedStatement = prepare(
                "UPDATE FROM questions SET image_part=? WHERE question_id=?"
        )){
            preparedStatement.setBlob(1, (Blob) image);
            preparedStatement.setInt(2, question_id);
        }
    }

    private void updateCorrect(int question_id, String correct) throws SQLException {
        try (PreparedStatement preparedStatement = prepare(
                "UPDATE FROM questions SET correct_answer=? WHERE question_id=?"
        )){
            preparedStatement.setString(1, correct);
            preparedStatement.setInt(2, question_id);
        }
    }

    /**
     * Krijgt een Result en gaat alle data(uit questions) één per één als {@link Question} opslaan
     */
    private void addRow(ResultSet resultSet) throws SQLException {
        questionList.add(new Question(resultSet.getInt(1), resultSet.getString(2)
                , resultSet.getString(3), resultSet.getBytes(4),
                resultSet.getString(5), resultSet.getString(6)));
    }
}