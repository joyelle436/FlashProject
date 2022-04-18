package be.ugent.flash.viewer.visitors;

import be.ugent.flash.viewer.cards.PictureCard;
import be.ugent.flash.data.Part;
import be.ugent.flash.data.Question;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.*;
import javafx.scene.layout.*;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * visitor voor een {@link PictureCard}
 */
public class PictureCardVisitor implements CardVisitor<PictureCard>{

    @Override
    public void buildCard(PictureCard pictureCard){
        pictureCard.accept(new PictureCardVisitor());
    }

    /**
     * maakt het uiterlijk van de kaart aan
     */
    @Override
    public void visit(PictureCard pictureCard) {
        pictureCard.build();
        GridPane answersGridPane = pictureCard.getAnswersGridPane();
        List<Part> answersPictures = pictureCard.getAnswers();
        Question row = pictureCard.getQuestionRow();
        int i = 0;
        int j = 0;
        for(Part part: answersPictures){
            Image answerImage = new Image(new ByteArrayInputStream(part.part()));
            ToggleButton toggleButton = new ToggleButton();
            toggleButton.setGraphic(new ImageView(answerImage));
            pictureCard.addToToggleAnswer(toggleButton, part.part_id());
            GridPane.setConstraints(toggleButton, i, j);
            pictureCard.addToggleButton(toggleButton);
            answersGridPane.getChildren().add(toggleButton);
            toggleButton.setStyle("-fx-background-color: yellow");
            j = (i+1 < 3) ? j : j+1; //3 per rij
            i = (i+1 < 3) ? i+1 : 0;
        }
        answersGridPane.setHgap(5);
        answersGridPane.setVgap(5);
        if(row.middleImage() != null){
            pictureCard.setBottom(answersGridPane);
            BorderPane.setMargin(answersGridPane, new Insets(0, 15, 50, 30));
        } else {
            pictureCard.setCenter(answersGridPane);
            BorderPane.setMargin(answersGridPane, new Insets(25, 15, 50, 30));
        }
        pictureCard.handleEvents();
    }
}