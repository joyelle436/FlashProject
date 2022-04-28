package be.ugent.flash.command.rights;

import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.command.*;
import be.ugent.flash.data.Part;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

import java.io.ByteArrayInputStream;

/**
 * Dit is alleen voor een mci vraag
 */
public class AnswerChoiceImage extends AnswerChoiceObject {
    private final Button graphicButton;
    public AnswerChoiceImage(TitledPaneGridpane gridpane){
        super(gridpane);
        setMargin(checkBox, new Insets(28, 0, 0, 0));
        this.graphicButton = new Button();
        graphicButton.setPrefSize(75, 75);
        setMargin(removeButton, new Insets(25, 0, 0, 0));
        getChildren().addAll(checkBox, graphicButton, removeButton);
        GridPane.setMargin(this, new Insets(0, 0, 0, 15));
    }

    public void setGraphicButtonImage(ImageView imageView){
        imageView.setFitWidth(graphicButton.getPrefWidth());
        imageView.setFitHeight(graphicButton.getPrefHeight());
        graphicButton.setGraphic(imageView);
    }

    public void putInGridpane(Part part, int position) {
        if(part != null){
            Image image = new Image(new ByteArrayInputStream(part.part()));
            setGraphicButtonImage(new ImageView(image));
        }
        super.putInGridpane(part, position);
    }
}