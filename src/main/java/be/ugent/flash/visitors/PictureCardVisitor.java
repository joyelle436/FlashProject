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
        GridPane answersGridPane = pictureCard.getAnswersGridPane();
        Map<Integer, byte[]> answers = pictureCard.getAnswers();
        QuestionRow row = pictureCard.getQuestionRow();
        int i = 0;
        int j = 0;
        for(Integer key: answers.keySet()){
            Image answerImage = new Image(new ByteArrayInputStream(answers.get(key)));
            ToggleButton toggleButton = new ToggleButton();
            toggleButton.setGraphic(new ImageView(answerImage));
            pictureCard.addToToggleAnswer(toggleButton, key);
            GridPane.setConstraints(toggleButton, i, j);
            pictureCard.addToggleButton(toggleButton);
            answersGridPane.getChildren().add(toggleButton);
            toggleButton.setStyle("-fx-background-color: yellow");
            i = (i <= 2) ? i+1 : 0;
            j = (i <= 2) ? j : j+1; //3 per rij
        }
        answersGridPane.layout();
        answersGridPane.setHgap(5);
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