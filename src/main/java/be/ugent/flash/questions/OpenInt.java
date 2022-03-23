package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * openi
 */
public class OpenInt extends Type {

    private ImageView imageView;

    public OpenInt(Stage stage, String DATA, String[] row) {
        super(stage, DATA, row);
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
    public void getAnswers() {
    }

    @Override
    public void addAnswers() {

    }


    @Override
    public void addImage(){

    }
}
