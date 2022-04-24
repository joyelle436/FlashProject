package be.ugent.flash.command;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Dit is allen voor mcs, mcc en mr vragen
 */
public class AnswerChoiceTextField extends HBox implements AnswerChoice {
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

    @Override
    public void setPosition(int position) {
        GridPane.setConstraints(this, 0, position);
    }

    @Override
    public void changePosition(int position) {
        if(position < GridPane.getRowIndex(this)){
            GridPane.setRowIndex(this, GridPane.getRowIndex(this));
        }
    }
}
