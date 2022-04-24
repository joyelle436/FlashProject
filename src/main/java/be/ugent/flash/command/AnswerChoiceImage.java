package be.ugent.flash.command;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * Dit is alleen voor een mci vraag
 */
public class AnswerChoiceImage extends HBox implements AnswerChoice {
    private final CheckBox checkBox;
    private final ToggleButton toggleButton;
    private final Button removeButton;
    public AnswerChoiceImage(){
        this.checkBox = new CheckBox();
        setMargin(checkBox, new Insets(9, 0, 0, 0));
        this.toggleButton = new ToggleButton();
        toggleButton.setPrefSize(150, 150);
        this.removeButton = new Button(" x ");
        setMargin(removeButton, new Insets(6, 0, 0, 0));
        setSpacing(7);
        getChildren().addAll(checkBox, toggleButton, removeButton);
        GridPane.setMargin(this, new Insets(0, 0, 0, 15));
    }

    private void setToggleButtonImage(ImageView imageView){
        toggleButton.setGraphic(imageView);
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
