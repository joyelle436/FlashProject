package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.List;


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
    protected final boolean hasImage;
    protected final ImageView imageView;
    protected final String[] row;
    protected final List<String[]> answers;
    protected int answersSize;

    protected Type(Stage stage, String DATA, String[] row, List<String[]> answers){
        this.DATA = DATA;
        this.stage = stage;
        this.answers = answers; //heeft antwoorden van die specifieke vraag
        this.row = row; //heeft hele rij van questions tabel
        this.answersSize = answers.size();;
        hasImage = row[4] != null;
        setId("borderpane");
        textFlow = new TextFlow();
        textFlow.setId("textflow");
        text = new Text();
        text.setId("text");
        text.setText(row[2]);
        setTop(textFlow);
        textFlow.getChildren().add(text);
        imageView = new ImageView();
        imageView.setId("imageview");
        setMargin(textFlow, new Insets(0, 0, 15, 0));
        getStylesheets().add(getClass().getResource("/be/ugent/flash/flash.css").toString());
    }

    public void build(){
    }

    public abstract void addImage();
    public void showQuestion(){
        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}