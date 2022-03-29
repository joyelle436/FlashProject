package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

/**
 * open
 */
public class OpenStr extends Type {

    public OpenStr(Stage stage, String DATA, String[] row, List<String[]> answers, byte[] aByte) {
        super(stage, DATA, row, answers, aByte);
    }

    public void build(){
        super.build();
        text.setFont(new Font(25));
        answerField = new TextField();
        answerField.setId("textfield");
        setBottom(answerField);
        setMargin(textFlow, new Insets(50, 15, 0, 15));
        setMargin(answerField, new Insets(0, 15, 100, 25));
    }
}
