package be.ugent.flash.cardspanes;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class OpenQuestionPane extends QuestionPane {

    private final Label label;
    private final HBox hbox;
    private TextField correctTextField;
    public OpenQuestionPane(){
        this.label = new Label("Correct Antwoord");
        this.hbox = new HBox();
        hbox.setMaxHeight(50);
        hbox.setAlignment(Pos.CENTER_LEFT);
        label.setFont(new Font(13));
        correctTextField = new TextField();
        correctTextField.setFont(new Font(13));
        correctTextField.setPrefWidth(200);
        hbox.getChildren().addAll(label, correctTextField);
        HBox.setMargin(label, new Insets(0, 5, 0, 0));
        getChildren().add(hbox);
    }

    public void fill(){
        super.fill();
        addBottomButtons();
    }

    public void setCorrectTextField(String correctString){
        correctTextField.setText(correctString);
    }
}