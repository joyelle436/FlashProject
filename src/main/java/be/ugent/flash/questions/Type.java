package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * superklasse van alle soort vragen
 */
public abstract class Type extends VBox {
    protected TextFlow textFlow;
    protected Text text;
    protected Stage stage;
    protected String database;

    public Type(Stage stage, String database){
        this.stage = stage;
        this.database = database;
        getStylesheets().add(getClass().getResource("/be/ugent/flash/flash.css").toString());
        setId("questionVbox");
        setAlignment(Pos.TOP_CENTER);
        textFlow = new TextFlow();
        textFlow.setId("textflow");
        setMargin(textFlow, new Insets(100, 0, 0, 0));
        textFlow.setPadding(new Insets(0, 15, 15, 20));
        text = new Text();
        text.setId("text");
        textFlow.getChildren().add(text);
        getChildren().addAll(textFlow);
    }

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
