package be.ugent.flash.questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Dit vbox krijg wordt vul in gegevens uit de databank
 */
public class Question extends VBox {

    private final String[] rows;
    private final Stage stage;

    public Question(String[] rows, Stage stage){
        this.stage = stage;
        this.rows = rows;
        setId("vbox");
        getStylesheets().add(getClass().getResource("/be/ugent/flash/flash.css").toString());
    }

    public void addQuestion(){
        setAlignment(Pos.TOP_CENTER);
        TextFlow textFlow = new TextFlow();
        textFlow.setId("textflow");
        setMargin(textFlow, new Insets(130, 0, 0, 0));
        textFlow.setPadding(new Insets(0, 15, 15, 20));
        Text text = new Text();
        text.setId("text");
        text.setText(rows[2]);
        textFlow.getChildren().add(text);
        TextField textField = new TextField();
        textField.setId("textfield");
        setMargin(textField, new Insets(50, 0, 0, 0));
        getChildren().addAll(textFlow, textField);
    }

    public void showQuestion() throws IOException {
        addQuestion();
        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}