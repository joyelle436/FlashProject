package be.ugent.flash.viewer.visitors;

import be.ugent.flash.viewer.cards.CompactCard;
import be.ugent.flash.db.Part;
import javafx.geometry.*;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;

import java.util.*;

public class CompactCardVisitor implements CardVisitor<CompactCard>{

    @Override
    public void buildCard(CompactCard compactCard){
        compactCard.accept(new CompactCardVisitor());
    }
    @Override
    public void visit(CompactCard compactCard) {
        compactCard.build();
        GridPane answersGridPane = compactCard.getAnswersGridPane();
        /* lijst met alle antwoorden */
        List<Part> answersStrings = compactCard.getAnswers();
        int j = 0;
        for(int i = 0; i < answersStrings.size(); i++){
            j = (i > 0 && i % 3 == 0) ? j+1 : j; //3 per rij
            ToggleButton toggleButton = new ToggleButton(new String(answersStrings.get(i).part()));
            toggleButton.setId("togglebutton");
            GridPane.setConstraints(toggleButton, i-(3*j), j);
            compactCard.addToggleButton(toggleButton);
            answersGridPane.getChildren().add(toggleButton);
        }
        answersGridPane.setHgap(5);
        answersGridPane.setVgap(5);
        compactCard.setBottom(answersGridPane);
        BorderPane.setMargin(answersGridPane, new Insets(50));
        compactCard.handleEvents();
    }
}