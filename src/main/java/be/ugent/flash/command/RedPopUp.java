package be.ugent.flash.command;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

/**
 *
 */
public class RedPopUp extends BorderPane implements EventHandler<ActionEvent> {

    private final Stage stage;
    public RedPopUp(String message){
        setId("popUpBorderPane");
        setPrefSize(350, 250);
        this.stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        Label exclamation = new Label("!");
        exclamation.setId("exclamation");
        BorderPane.setAlignment(exclamation, Pos.CENTER_RIGHT);
        BorderPane.setMargin(exclamation, new Insets(0, 0, 0, 20));
        Button button = new Button("OK");
        button.setId("bottomButton");
        button.setOnAction(this);
        BorderPane.setAlignment(button, Pos.CENTER);
        BorderPane.setMargin(button, new Insets(0, 0, 10, 0));
        Text text = new Text(message);
        text.setFont(new Font(25));
        text.setFill(Paint.valueOf("white"));
        TextFlow textFlow = new TextFlow(text);
        textFlow.setId("popUpTextflow");
        BorderPane.setAlignment(textFlow, Pos.CENTER);
        BorderPane.setMargin(textFlow, new Insets(50, 20, 0, 0));
        setLeft(exclamation);
        setCenter(textFlow);
        setBottom(button);
        stage.setScene(new Scene(this));
        stage.show();
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/flash/flash.css")).toString());
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.close();
    }
}
