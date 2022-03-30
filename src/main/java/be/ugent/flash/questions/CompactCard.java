package be.ugent.flash.questions;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;

/**
 * mcc
 */
public class CompactCard extends Type {

    private ToggleGroup wordsgroup;
    public CompactCard(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers) {
        super(stage, row, answers);
        this.wordsgroup = new ToggleGroup();
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(22.5));
        GridPane gridpane = new GridPane();
        gridpane.setId("anchorpane");
        for(int i = 0; i < answers.size(); i++){
            ToggleButton toggleButton = new ToggleButton(new String(answers.get(new ArrayList<>(answers.keySet()).get(i))));
            toggleButton.setId("togglebutton");
            GridPane.setConstraints(gridpane, i, 0);
            GridPane.setConstraints(toggleButton, gridpane.getColumnCount()+1, 0);
            wordsgroup.getToggles().add(toggleButton);
            gridpane.getChildren().add(toggleButton);
        }
        gridpane.layout();
        gridpane.setHgap(5);
        setBottom(gridpane);
        setMargin(gridpane, new Insets(0, 15, 50, 15));
        handleEvents();
    }

    private void handleEvents() {
        for(int t = 0; t < wordsgroup.getToggles().size(); t++){
            ToggleButton selectedToggle = (ToggleButton) wordsgroup.getToggles().get(t);
            selectedToggle.setOnAction(actionEvent -> {
                int key = new ArrayList<>(answers.keySet()).get((Integer.parseInt(new String(row.get(5))))-1);
                String selectedText = selectedToggle.getText();
                answerFound = selectedText.equals(new String(answers.get(key)));
                this.goToNext = true;
                Platform.exit();
            });
        }
    }
}