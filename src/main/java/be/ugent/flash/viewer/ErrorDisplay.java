package be.ugent.flash.viewer;

import be.ugent.flash.viewer.cards.Type;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;

/**
 * Bevat een alert voor een databank error en de foutmelding van als een vraag fout is
 */
public class ErrorDisplay {

    /*
    Wordt getoond als er iets misloopt
     */
    public void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.NONE);
        ButtonType buttonType = new ButtonType("OK");
        alert.getButtonTypes().add(buttonType);
        alert.setTitle("ERROR");
        alert.setContentText(message);
        alert.show();
    }

    public void showErrorLabel(Type card){
        card.setPopUpLabelVisible(true);
        new Timeline(
                new KeyFrame(Duration.seconds(1.5), e -> card.setPopUpLabelVisible(false))).play();
    }
}
