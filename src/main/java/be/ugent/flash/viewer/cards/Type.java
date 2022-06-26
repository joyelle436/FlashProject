package be.ugent.flash.viewer.cards;

import be.ugent.flash.db.Part;
import be.ugent.flash.db.Question;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
public abstract class Type extends BorderPane implements InvalidationListener {
    protected TextFlow textFlow;
    private final Text text;
    protected boolean answerFound;
    private final Stage stage;
    protected final Question questionRow;
    protected final GridPane answersGridpane;
    protected CardModel model;
    protected List<Part> answers;
    private final Label popUpLabel;
    private Type nextCard;

    protected Type(Stage stage, Question questionRow){
        this.stage = stage;
        this.questionRow = questionRow; /* bevat hele rij van questions tabel dus een hele vraag */
        this.answerFound = false;
        this.answersGridpane = new GridPane();
        this.nextCard = null;
        this.textFlow = new TextFlow();
        this.text = new Text();
        this.popUpLabel = new Label(" Het antwoord was fout");
    }

    /**
     * Dit zijn componenten die in elke type vraag aanwezig (moeten) zijn
     */
    public void build(){
        GridPane contentGridPane = new GridPane();
        contentGridPane.setId("contentGridPane");
        popUpLabel.setId("popUpLabel");
        popUpLabel.setVisible(false);
        GridPane.setConstraints(popUpLabel, 0, 0);
        GridPane.setConstraints(textFlow, 0, 1);
        setId("borderpane");
        textFlow.setId("textflow");
        text.setId("text");
        addImage();
        text.setText(questionRow.text());
        contentGridPane.getChildren().addAll(popUpLabel, textFlow);
        contentGridPane.setVgap(20);
        setTop(contentGridPane);
        textFlow.getChildren().add(text);
        setMargin(contentGridPane, new Insets(15));
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    public void setModel(CardModel model){
        this.model = model;
        model.addListener(this);
    }
    public Question getQuestionRow() {
        return questionRow;
    }

    public Type getNextCard(){
        return nextCard;
    }

    public void setPopUpLabelVisible(boolean visible){
        popUpLabel.setVisible(visible);
    }

    /**
     * kaart dat getoont wordt na deze
     */
    public void setNextCard(Type next){
        nextCard = next;
    }

    public GridPane getAnswersGridPane() {
        return answersGridpane;
    }

    /**
     * wordt gebruikt als de vraag opnieuw gesteld moet worden
     */
    public void clear() {
        setPopUpLabelVisible(false);
    }

    /**
     * foto toevoegen als dit bestaat
     */
    public void addImage(){
        if(questionRow.middleImage() != null){
            Image mainImage = new Image(new ByteArrayInputStream(questionRow.middleImage()));
            ImageView imageView = new ImageView(mainImage);
            imageView.setFitWidth(400);
            imageView.setFitHeight(200);
            imageView.setPreserveRatio(true);
            setCenter(imageView);
            BorderPane.setAlignment(imageView, Pos.CENTER);
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
        stage.centerOnScreen();
        stage.show();
    }

    /**
     * toont de kaart dat volgt na deze
     */
    protected void showNextCard(){
        if(nextCard != null){
            if(nextCard.getScene() != null){
                stage.setScene(nextCard.getScene());
            } else {
                stage.setScene(new Scene(nextCard, Color.TRANSPARENT));
            }
            if(!stage.isShowing()){
                stage.show();
            }
        } else {
            stage.close();
        }
    }

    @Override
    public void invalidated(Observable observable) {
        int index = model.getAllCards().indexOf(this);
        model.change(index);
    }
    /*
    Dit methode is verschillend voor elke subklasse
     */
    public void handleEvents(){
    }

    public void verifyAnswer(){
        if(answerFound){
            model.removeCard(this);
        } else {
            model.addAsLast(this);
        }
    }

    /*
    Dit methode is verschillend voor elke subklasse
     */
    public void setAnswers(List<Part> answers){
        this.answers = answers;
    }

    public List<Part> getAnswers(){
        return answers;
    }
}