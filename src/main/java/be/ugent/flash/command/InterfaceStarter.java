package be.ugent.flash.command;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceStarter {

    private final Stage stage;
    private final MainBorderPane mainBorderPane;

    public InterfaceStarter(Stage stage){
        this.stage = stage;
        this.mainBorderPane = new MainBorderPane(stage);
        mainBorderPane.setObject(mainBorderPane);
    }

    public void startTheWindow(){
        mainBorderPane.makeComponents();
        stage.setScene(new Scene(mainBorderPane));
        stage.setResizable(false);
        stage.setTitle(" ".repeat(150) + "Flash: beheersinterface");
        stage.show();
    }
}
