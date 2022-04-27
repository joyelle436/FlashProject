package be.ugent.flash.command.rights;

import be.ugent.flash.cardspanes.PositionChanger;
import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.command.PartData;
import be.ugent.flash.command.PictureCardPart;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * Dit is alleen voor een mci vraag
 */
public class AnswerChoiceImage extends HBox implements AnswerChoice, PositionChanger {
    private final CheckBox checkBox;
    private final Button graphicButton;
    private final Button removeButton;
    private final TitledPaneGridpane gridpane;
    public AnswerChoiceImage(TitledPaneGridpane gridpane){
        this.gridpane = gridpane;
        this.checkBox = new CheckBox();
        setMargin(checkBox, new Insets(28, 0, 0, 0));
        this.graphicButton = new Button();
        graphicButton.setPrefSize(75, 75);
        this.removeButton = new Button(" x ");
        removeButton.setOnAction(this);
        setMargin(removeButton, new Insets(25, 0, 0, 0));
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
    public void putInGridpane(PartData partData, int position) {
        if(partData != null){
            Image image = ((PictureCardPart) partData).getImagePart();
            setGraphicButtonImage(new ImageView(image));
        }
        setPosition(position);
        gridpane.getChildren().add(this);
        gridpane.getOptionButton().increasePosition();
    }

    @Override
    public void removeFromGridpane() {
        gridpane.removeFromSet(this);
        gridpane.getChildren().remove(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        gridpane.setRowPosition(gridpane.getRowPosition()-1);
        removeFromGridpane();
    }

    @Override
    public void decreasePosition(){
        GridPane.setRowIndex(this, GridPane.getRowIndex(this)-2);
    }

    @Override
    public void increasePosition(){
        GridPane.setRowIndex(this, GridPane.getRowIndex(this)+1);
    }

    @Override
    public void changePosition(int index) {
        if(index < GridPane.getRowIndex(this)){
            decreasePosition();
            gridpane.setRowPosition(gridpane.getRowPosition()-1);
        }
    }
}
