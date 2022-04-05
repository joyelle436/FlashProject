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
        List<byte[]> answersStrings = new ArrayList<>(compactCard.getAnswers().values());
        for(int i = 0; i < answersStrings.size(); i++){
            ToggleButton toggleButton = new ToggleButton(new String(answersStrings.get(i)));
            toggleButton.setId("togglebutton");
            GridPane.setConstraints(gridPane, i, 0);
            GridPane.setConstraints(toggleButton, gridPane.getColumnCount()+1, 0);
            compactCard.addToggleButton(toggleButton);
            gridPane.getChildren().add(toggleButton);
        }
        gridPane.setHgap(5);
        compactCard.setBottom(gridPane);
        BorderPane.setMargin(gridPane, new Insets(0, 15, 50, 15));
        BorderPane.setAlignment(gridPane, Pos.CENTER);
        compactCard.handleEvents();
    }
}