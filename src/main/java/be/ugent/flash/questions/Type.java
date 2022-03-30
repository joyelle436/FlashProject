package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

import java.io.ByteArrayInputStream;
import java.util.*;


/**
 * superklasse van alle soort vragen. Krijg zijn id in de constructor zodat
 * de klasse zijn antwoorden kan opvragen in de databa-nk
 */
public abstract class Type extends BorderPane {
    protected TextFlow textFlow;
    protected Text text;
    protected boolean answerFound;
    protected final Stage stage;
    protected final List<byte[]> row;
    protected final Map<Integer, byte[]> answers;

    protected Type(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers){
        this.stage = stage;
        this.answers = answers; //heeft antwoorden van die specifieke vraag
        this.row = row; //heeft hele rij van questions tabel
        this.answerFound = true;
    }

    public void build(){
        setId("borderpane");
        addImage();
        textFlow = new TextFlow();
        textFlow.setId("textflow");
        text = new Text();
        text.setId("text");
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
    public void showQuestion(){
        Scene scene = new Scene(this, Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
}