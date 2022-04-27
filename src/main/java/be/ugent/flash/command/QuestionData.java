package be.ugent.flash.command;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class QuestionData {

    private final int id;
    private StringProperty title;
    private StringProperty text;
    private byte[] middelImage;
    private final String questionType;
    private StringProperty correctAnswer;

    public QuestionData(int id, String title, String text, byte[] middelImage, String questionType, String correctAnswer) {
        this.id = id;
        setTitle(title);
        setText(text);
        this.middelImage = middelImage;
        this.questionType = questionType;
        setCorrectAnswer(correctAnswer);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return titleProperty().get();
    }

    public StringProperty titleProperty() {
        if(title == null){
            title = new SimpleStringProperty(this, "title");
        }
        return title;
    }

    public void setTitle(String title) {
        titleProperty().set(title);
    }

    public String getText() {
        return textProperty().get();
    }

    public StringProperty textProperty() {
        if(text == null){
            text = new SimpleStringProperty(this, "text");
        }
        return text;
    }

    public void setText(String text) {
        textProperty().set(text);
    }

    public byte[] getMiddelImage() {
        return middelImage;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setCorrectAnswer(String correctAnswer) {
        correctAnswerProperty().set(correctAnswer);
    }

    public StringProperty correctAnswerProperty() {
        if(correctAnswer == null){
            correctAnswer = new SimpleStringProperty(this, "correctAnswer");
        }
        return correctAnswer;
    }

    public String getCorrectAnswer() {
       return correctAnswerProperty().get();
    }

    public void setMiddelImage(byte[] middelImage) {
        this.middelImage = middelImage;
    }

    public void bindTitle(TextField textField) {
        titleProperty().bind(textField.textProperty());
    }

    public void bindText(TextArea textArea) {
        textProperty().bind(textArea.textProperty());
    }
}