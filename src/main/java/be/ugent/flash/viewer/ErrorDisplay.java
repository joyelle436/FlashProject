package be.ugent.flash.viewer;

import be.ugent.flash.viewer.cards.Type;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.text.NumberFormat;

/**
 * Bevat een paar methodes om foutmeldingen aan te tonen
 */
public class ErrorDisplay {
    /*
    Wordt getoond als er iets misloopt
     */
    public static void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.NONE);
        ButtonType buttonType = new ButtonType("OK");
        alert.getButtonTypes().add(buttonType);
        alert.setTitle("ERROR");
        alert.setContentText(message);
        alert.show();
    }

    /*
    Wordt getoond bij een fout antwoord in de viewer
     */
    public static void showErrorLabel(Type card){
        card.setPopUpLabelVisible(true);
        new Timeline(
                new KeyFrame(Duration.seconds(1.5), e -> card.setPopUpLabelVisible(false))).play();
    }
}
