package be.ugent.flash.cards;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.*;

/**
 * open
 */
public class OpenStrCard extends OpenQuestion {

    public OpenStrCard(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, row, answers, nextCard);
        foutlabel.setText("Antwoord kan niet leeg zijn");
    }

    public void handleEvents(){

    }
}
