package be.ugent.flash.viewer;

import be.ugent.flash.viewer.cards.Type;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.*;
import javafx.util.Duration;


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