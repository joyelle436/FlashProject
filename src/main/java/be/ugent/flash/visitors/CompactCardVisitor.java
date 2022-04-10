package be.ugent.flash.visitors;

import be.ugent.flash.cards.CompactCard;
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
        GridPane gridPane = compactCard.getGridPane();
        //lijst met alle antwoorden
        List<byte[]> answersStrings = new ArrayList<>(compactCard.getAnswers().values());
        int j = 0;
        for(int i = 0; i < answersStrings.size(); i++){
            ToggleButton toggleButton = new ToggleButton(new String(answersStrings.get(i)));
            toggleButton.setId("togglebutton");
            GridPane.setConstraints(gridPane, i, j);
            GridPane.setConstraints(toggleButton, gridPane.getColumnCount()+1, 0);
            compactCard.addToggleButton(toggleButton);
            gridPane.getChildren().add(toggleButton);
            j = (i % 3 != 0) ? j : j+1; //3 per rij
        }
        gridPane.setHgap(5);
        compactCard.setBottom(gridPane);
        BorderPane.setMargin(gridPane, new Insets(50));
        //BorderPane.setAlignment(gridPane, Pos.CENTER);
        compactCard.handleEvents();
    }
}