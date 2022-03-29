package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;


/**
 * openi
 */
public class OpenInt extends Type {

    private ImageView imageView;

    public OpenInt(Stage stage, String DATA, String[] row, List<String[]> answers) {
        super(stage, DATA, row, answers);
    }

    public void build(){
        super.build();
        text.setFont(new Font(25));
        answerField = new TextField();
        answerField.setId("textfield");
        imageView = new ImageView();
        imageView.setId("imageview");
        setCenter(answerField);
        setMargin(textFlow, new Insets(150, 15, 0, 15));
        setMargin(answerField, new Insets(-200, 15, 0, 0));
    }

    @Override
    public void addImage(){

    }
}
