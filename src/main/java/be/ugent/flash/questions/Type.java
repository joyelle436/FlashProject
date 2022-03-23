package be.ugent.flash.questions;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.*;
import javafx.stage.Stage;



/**
 * superklasse van alle soort vragen. Krijg zijn id in de constructor zodat
 * de klasse zijn antwoorden kan opvragen in de databa-nk
 */
public abstract class Type extends BorderPane {
    protected final String DATA;
    protected final TextFlow textFlow;
    protected final Text text;
    protected final Stage stage;
    protected TextField answerField;
    protected final Image pictureReference = null;

    public Type(Stage stage, String DATA, String[] row){
        this.DATA = DATA;
        this.stage = stage;
        setId("borderpane");
        textFlow = new TextFlow();
        textFlow.setId("textflow");
        text = new Text();
        text.setId("text");
        text.setText(row[2]);
        setTop(textFlow);
        textFlow.getChildren().add(text);
        getStylesheets().add(getClass().getResource("/be/ugent/flash/flash.css").toString());
    }

    public void build(){
    }

    public abstract void addImage();
    public abstract void getAnswers();
    public abstract void addAnswers();
    public void showQuestion(){
        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}