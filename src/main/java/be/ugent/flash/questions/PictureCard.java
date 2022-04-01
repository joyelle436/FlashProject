package be.ugent.flash.questions;

import be.ugent.flash.visitors.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * mci
 */
public class PictureCard extends Type implements CardItem<PictureCard> {
    private final GridPane gridpane;
    private ToggleGroup picturegroup;
    //key togglebutton, value: antwoord part id
    private final Map<ToggleButton, Integer> toggleAnswers;
    public PictureCard(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers, Type nextCard) {
        super(stage, row, answers, nextCard);
        gridpane = new GridPane();
        toggleAnswers = new HashMap<>();
        picturegroup = new ToggleGroup();
    }

    @Override
    public void build() {
        super.build();
        int i = 0;
        for(Integer key: answers.keySet()){
            Image answerImage = new Image(new ByteArrayInputStream(answers.get(key)));
            ToggleButton toggleButton = new ToggleButton();
            toggleButton.setGraphic(new ImageView(answerImage));
            toggleAnswers.put(toggleButton, key);
            GridPane.setConstraints(toggleButton, i, 0);
            GridPane.setConstraints(toggleButton, gridpane.getColumnCount()+1, 0);
            picturegroup.getToggles().add(toggleButton);
            gridpane.getChildren().add(toggleButton);
            toggleButton.getStyleClass().add("yellow");
        }
        gridpane.layout();
        gridpane.setHgap(5);
        if(row.get(3) != null){
            setBottom(gridpane);
            setMargin(gridpane, new Insets(0, 15, 50, 30));
        } else {
            setCenter(gridpane);
            setMargin(textFlow, new Insets(175, 15, 0, 15));
            setMargin(gridpane, new Insets(25, 15, 50, 30));
        }
        handleEvents();
    }

    private void handleEvents() {
        for(int t = 0; t < picturegroup.getToggles().size(); t++){
            ToggleButton selectedToggle = (ToggleButton) picturegroup.getToggles().get(t);
            selectedToggle.setOnAction(actionEvent -> {
                String selected = String.valueOf(toggleAnswers.get(selectedToggle));
                int index = Integer.parseInt(new String(row.get(5))) - 1;
                String correct = String.valueOf(new ArrayList<>(answers.keySet()).get(index));
                answerFound = selected.equals(correct);
                showNextCard();
            });
        }
    }

    @Override
    public void accept(CardVisitor cardVisitor) {
        cardVisitor.visit(this);
    }
}
