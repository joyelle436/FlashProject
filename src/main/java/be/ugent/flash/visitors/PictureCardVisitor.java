package be.ugent.flash.visitors;

import be.ugent.flash.QuestionRow;
import be.ugent.flash.cards.PictureCard;
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
        GridPane gridPane = pictureCard.getGridPane();
        Map<Integer, byte[]> answers = pictureCard.getAnswers();
        QuestionRow row = pictureCard.getQuestionRow();
        int i = 0;
        for(Integer key: answers.keySet()){
            Image answerImage = new Image(new ByteArrayInputStream(answers.get(key)));
            ToggleButton toggleButton = new ToggleButton();
            toggleButton.setGraphic(new ImageView(answerImage));
            pictureCard.addToToggleAnswer(toggleButton, key);
            GridPane.setConstraints(toggleButton, i, 0);
            pictureCard.addToggleButton(toggleButton);
            gridPane.getChildren().add(toggleButton);
            toggleButton.setStyle("-fx-background-color: yellow");
            i++;
        }
        gridPane.layout();
        gridPane.setHgap(5);
        if(row.middleImage() != null){
            pictureCard.setBottom(gridPane);
            BorderPane.setMargin(gridPane, new Insets(0, 15, 50, 30));
        } else {
            pictureCard.setCenter(gridPane);
            BorderPane.setMargin(gridPane, new Insets(25, 15, 50, 30));
        }
        pictureCard.handleEvents();
    }
}
