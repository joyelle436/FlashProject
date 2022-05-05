package be.ugent.flash.command;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceStarter {

    private final Stage stage;
    private final MainBorderPane mainBorderPane;

    public InterfaceStarter(Stage stage){
        this.stage = stage;
        stage.setTitle(" ".repeat(150) + "Flash: beheersinterface");
        this.mainBorderPane = new MainBorderPane(stage);
    }

    public void startTheWindow(){
        mainBorderPane.makeComponents();
        Scene scene = new Scene(mainBorderPane);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}