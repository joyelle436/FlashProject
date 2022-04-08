package be.ugent.flash.cards;

import be.ugent.flash.QuestionRow;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

import java.io.ByteArrayInputStream;
import java.util.*;


/**
 * superklasse voor alle soort vragen. Dient ook als view en controller
 */
public abstract class Type extends BorderPane {
    protected TextFlow textFlow;
    private final Text text;
    protected boolean answerFound;
    private final Stage stage;
    protected final QuestionRow questionRow;
    protected final Map<Integer, byte[]> answers;
    protected final GridPane gridPane;
    protected boolean goToNext;
    protected CardModel model;
    private Type nextCard;

    protected Type(Stage stage, QuestionRow questionRow, Map<Integer, byte[]> answers){
        this.stage = stage;
        this.answers = answers; //heeft antwoorden van die specifieke vraag
        this.questionRow = questionRow; //heeft hele rij van questions tabel dus een hele vraag
        this.answerFound = false;
        this.gridPane = new GridPane();
        this.nextCard = null;
        this.textFlow = new TextFlow();
        this.text = new Text();
        this.goToNext = false;
    }

    /**
     * Dit zijn componenten die in elke type vraag aanwezig moeten zijn
     */
    public void build(){
        setId("borderpane");
        textFlow.setId("textflow");
        text.setId("text");
        addImage();
        text.setText(questionRow.text());
        setTop(textFlow);
        textFlow.getChildren().add(text);
        if(questionRow.middleImage() != null){
            setMargin(textFlow, new Insets(35, 15, 0, 15));
        } else {
            setMargin(textFlow, new Insets(25, 15, 0, 15));
        }
        getStylesheets().add(getClass().getResource("/be/ugent/flash/flash.css").toString());
    }

    public void setModel(CardModel model){
    }
    public QuestionRow getQuestionRow() {
        return questionRow;
    }

    public Map<Integer, byte[]> getAnswers() {
        return answers;
    }

    public Type getNextCard(){
        return nextCard;
    }

    /**
     * kaart dat getoont wordt na deze
     */
    public void setNextCard(Type next){
        nextCard = next;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public boolean isAnswerFound(){
        return answerFound;
    }

    /**
     * wordt gebruikt als het antwoord niet gevonden wordt
     */
    public abstract void clear();
    /**
     * foto toevoegen als dit bestaat
     */
    public void addImage(){
        if(questionRow.middleImage() != null){
            Image mainImage = new Image(new ByteArrayInputStream(questionRow.middleImage()));
            ImageView imageView = new ImageView(mainImage);
            setCenter(imageView);
        }
    }

    /**
     * voeg het kaart toe aan de stage
     */
    public void showQuestion(){
        Scene scene = new Scene(this, Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    /**
     * toont de kaart dat volgt na deze
     */
    protected void showNextCard(){
        if(nextCard != null){
            if(nextCard.getScene() != null){
                stage.setScene(nextCard.getScene());
                if(!stage.isShowing()){
                    stage.show();
                }
            } else {
                stage.setScene(new Scene(nextCard, Color.TRANSPARENT));
            }
        } else {
            stage.close();
        }
    }
}