package be.ugent.flash.command;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AnswerChoiceTextField extends HBox {
    private final CheckBox checkBox;
    private final TextField textField;
    private final Button removeButton;
    public AnswerChoiceTextField(){
        this.checkBox = new CheckBox();
        setMargin(checkBox, new Insets(9, 0, 0, 0));
        this.textField = new TextField();
        textField.setPrefSize(550, 40);
        this.removeButton = new Button(" x ");
        setMargin(removeButton, new Insets(6, 0, 0, 0));
        setSpacing(7);
        getChildren().addAll(checkBox, textField, removeButton);
        GridPane.setMargin(this, new Insets(0, 0, 0, 15));
    }

    public void addText(String text){
        textField.setText(text);
    }
}
