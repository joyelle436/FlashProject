package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.util.List;


/**
 * superklasse van alle soort vragen. Krijg zijn id in de constructor zodat
 * de klasse zijn antwoorden kan opvragen in de databa-nk
 */
public abstract class Type extends BorderPane {
    protected final String DATA;
    protected TextFlow textFlow;
    protected Text text;
    protected final Stage stage;
    protected TextField answerField;
    protected final String[] row;
    protected final List<String[]> answers;
    protected int answersSize;
    protected byte[] aByte;

    protected Type(Stage stage, String DATA, String[] row, List<String[]> answers, byte[] aByte){
        this.DATA = DATA;
        this.stage = stage;
        this.answers = answers; //heeft antwoorden van die specifieke vraag
        this.row = row; //heeft hele rij van questions tabel
        this.answersSize = answers.size();
        this.aByte = aByte;
    }

    public void build(){
        setId("borderpane");
        textFlow = new TextFlow();
        textFlow.setId("textflow");
        text = new Text();
        text.setId("text");
        text.setText(row[2]);
        setTop(textFlow);
        textFlow.getChildren().add(text);
        setMargin(textFlow, new Insets(0, 0, 15, 0));
        addImage();
        getStylesheets().add(getClass().getResource("/be/ugent/flash/flash.css").toString());
    }

    /**
     * foto toevoegen als dit bestaat
     */
    public void addImage(){
        if(aByte != null){
            Image mainImage = new Image(new ByteArrayInputStream(aByte));
            ImageView imageView = new ImageView(mainImage);
            setCenter(imageView);
        }
    }
    public void showQuestion(){
        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}