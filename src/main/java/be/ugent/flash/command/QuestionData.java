package be.ugent.flash.command;


public class QuestionData {

    private final int id;
    private String title;
    private String text;
    private byte[] middelImage; /* TODO: aanpassen */
    private final String questionType;
    private String correctAnswer;

    public QuestionData(int id, String title, String text, byte[] middelImage, String questionType, String correctAnswer) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.middelImage = middelImage;
        this.questionType = questionType;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public byte[] getMiddelImage() {
        return middelImage;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setMiddelImage(byte[] middelImage) {
        this.middelImage = middelImage;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}