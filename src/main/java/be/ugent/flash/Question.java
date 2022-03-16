package be.ugent.flash;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Question {
    private final Stage stage;

    //constructor krijgt de naam van de databank en de stage
    public Question(Stage stage) {
        this.stage = stage;
    }

    public void openStage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("open.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
