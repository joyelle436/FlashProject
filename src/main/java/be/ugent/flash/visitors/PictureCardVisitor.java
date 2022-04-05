package be.ugent.flash.visitors;

import be.ugent.flash.cards.PictureCard;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

public class PictureCardVisitor implements CardVisitor<PictureCard>{

    @Override
    public void buildCard(PictureCard pictureCard){
        pictureCard.accept(new PictureCardVisitor());
    }
    @Override
    public void visit(PictureCard pictureCard) {
        pictureCard.build();
        GridPane gridPane = pictureCard.getGridPane();
        Map<Integer, byte[]> answers = pictureCard.getAnswers();
        List<byte[]> row = pictureCard.getRow();
        int i = 0;
        for(Integer key: answers.keySet()){
            Image answerImage = new Image(new ByteArrayInputStream(answers.get(key)));
            ToggleButton toggleButton = new ToggleButton();
            toggleButton.setGraphic(new ImageView(answerImage));
            pictureCard.addToToggleAnswer(toggleButton, key);
            GridPane.setConstraints(toggleButton, i, 0);
            pictureCard.addToggleButton(toggleButton);
            gridPane.getChildren().add(toggleButton);
            toggleButton.getStyleClass().add("yellow");
            i++;
        }
        gridPane.layout();
        gridPane.setHgap(5);
        if(row.get(3) != null){
            pictureCard.setBottom(gridPane);
            BorderPane.setMargin(gridPane, new Insets(0, 15, 50, 30));
        } else {
            pictureCard.setCenter(gridPane);
            BorderPane.setMargin(gridPane, new Insets(25, 15, 50, 30));
        }
        pictureCard.handleEvents();
    }
}
