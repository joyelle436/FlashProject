package be.ugent.flash;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceStarter {

    private final Stage stage;
    private final StartWindow startWindow;

    public InterfaceStarter(Stage stage){
        this.stage = stage;
        this.startWindow = new StartWindow(stage);
    }

    public void startTheWindow(){
        startWindow.makeComponents();
        stage.setScene(new Scene(startWindow));
        stage.setResizable(false);
        stage.setTitle(" ".repeat(150) + "Flash: beheersinterface");
        stage.show();
    }
}
