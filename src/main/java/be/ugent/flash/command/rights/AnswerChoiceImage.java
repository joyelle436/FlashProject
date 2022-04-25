package be.ugent.flash.command.rights;

import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.command.PartData;
import be.ugent.flash.command.PictureCardPart;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * Dit is alleen voor een mci vraag
 */
public class AnswerChoiceImage extends HBox implements AnswerChoice {
    private final CheckBox checkBox;
    private final Button graphicButton;
    private final Button removeButton;
    public AnswerChoiceImage(){
        this.checkBox = new CheckBox();
        setMargin(checkBox, new Insets(9, 0, 0, 0));
        this.graphicButton = new Button();
        graphicButton.setPrefSize(75, 75);
        this.removeButton = new Button(" x ");
        setMargin(removeButton, new Insets(6, 0, 0, 0));
        setSpacing(7);
        getChildren().addAll(checkBox, graphicButton, removeButton);
        GridPane.setMargin(this, new Insets(0, 0, 0, 15));
    }

    public void setGraphicButtonImage(ImageView imageView){
        imageView.setFitWidth(graphicButton.getPrefWidth());
        imageView.setFitHeight(graphicButton.getPrefHeight());
        graphicButton.setGraphic(imageView);
    }

    @Override
    public void setPosition(int position) {
        GridPane.setConstraints(this, 0, position);
    }

    @Override
    public void changePosition(int position) {
        if(position < GridPane.getRowIndex(this)){
            GridPane.setRowIndex(this, GridPane.getRowIndex(this)-1);
        }
    }

    @Override
    public void putInGridpane(PartData partData, TitledPaneGridpane gridpane, int position) {
        Image image = ((PictureCardPart) partData).getImagePart();
        setGraphicButtonImage(new ImageView(image));
        setPosition(position);
        gridpane.getChildren().add(this);
        gridpane.getOptionButton().increasePosition();
    }
}
