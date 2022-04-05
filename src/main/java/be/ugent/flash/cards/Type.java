package be.ugent.flash.cards;

import javafx.application.Platform;
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
 * superklasse van alle soort vragen.
 */
public abstract class Type extends BorderPane {
    protected TextFlow textFlow;
    private final Text text;
    protected boolean answerFound;
    protected final Stage stage;
    protected final List<byte[]> row;
    protected final Map<Integer, byte[]> answers;
    protected final GridPane gridPane;
    protected boolean goToNext;
    private Type nextCard;

    protected Type(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard){
        this.stage = stage;
        this.answers = answers; //heeft antwoorden van die specifieke vraag
        this.row = row; //heeft hele rij van questions tabel dus een hele vraag
        this.answerFound = false;
        this.gridPane = new GridPane();
        this.nextCard = nextCard;
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
        text.setText(new String(row.get(2)));
        setTop(textFlow);
        textFlow.getChildren().add(text);
        if(row.get(3) != null){
            setMargin(textFlow, new Insets(75, 15, 0, 15));
        } else {
            setMargin(textFlow, new Insets(50, 15, 0, 15));
        }
        getStylesheets().add(getClass().getResource("/be/ugent/flash/flash.css").toString());
    }

    public List<byte[]> getRow() {
        return row;
    }

    public Map<Integer, byte[]> getAnswers() {
        return answers;
    }

    public Type getNextCard(){
        return nextCard;
    }

    public void setNextCard(Type next){
        nextCard = next;
    }

    public boolean canGoToNext() {
        return goToNext;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public boolean isAnswerFound(){
        return answerFound;
    }
    /**
     * foto toevoegen als dit bestaat
     */
    public void addImage(){
        if(row.get(3) != null){
            Image mainImage = new Image(new ByteArrayInputStream(row.get(3)));
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
            } else {
                stage.setScene(new Scene(nextCard, Color.TRANSPARENT));
            }
        } else {
            Platform.exit();
        }
    }
}