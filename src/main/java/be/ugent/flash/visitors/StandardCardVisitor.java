package be.ugent.flash.visitors;

import be.ugent.flash.cards.StandardCard;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.*;

public class StandardCardVisitor implements CardVisitor<StandardCard>{

    @Override
    public void buildCard(StandardCard standardCard){
        standardCard.accept(new StandardCardVisitor());
    }
    @Override
    public void visit(StandardCard standardCard) {
        standardCard.build();
        GridPane answersGridPane = standardCard.getAnswersGridPane();
        List<byte[]> answersStrings = new ArrayList<>(standardCard.getAnswers().values());
        for(int i = 0; i < answersStrings.size(); i++){
            ToggleButton toggleButton = new ToggleButton(" " + ((char) (i+65)) + " ");
            toggleButton.setId("togglebutton");
            Label label = new Label(new String(answersStrings.get(i)));
            label.setId("label");
            standardCard.addLabel(i, label);
            GridPane.setConstraints(toggleButton, 0, i);
            GridPane.setConstraints(label, 1, i);
            standardCard.addToggle(toggleButton);
            answersGridPane.getChildren().add(toggleButton);
        }
        answersGridPane.getChildren().addAll(standardCard.getLabels());
        answersGridPane.setVgap(10);
        answersGridPane.setHgap(10);
        standardCard.setBottom(answersGridPane);
        BorderPane.setMargin(answersGridPane, new Insets(0, 15, 50, 15));
        standardCard.handleEvents();
    }
}