package be.ugent.flash.questions;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;

/**
 * mcs
 */
public class Standard extends Type {

    private GridPane gridpane;
    private ToggleGroup lettersGroup;
    private final Label[] labels;
    public Standard(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers) {
        super(stage, row, answers);
        labels = new Label[answers.size()];
        lettersGroup = new ToggleGroup();
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(22.5));
        gridpane = new GridPane();
        for(int i = 0; i < answers.size(); i++){
            ToggleButton toggleButton = new ToggleButton(" " + ((char) (i+65)) + " ");
            toggleButton.setId("togglebutton");
            Label label = new Label(new String(answers.get(new ArrayList<>(answers.keySet()).get(i))));
            label.setId("label");
            labels[i] = label;
            GridPane.setConstraints(toggleButton, 0, i);
            GridPane.setConstraints(label, 1, i);
            lettersGroup.getToggles().add(toggleButton);
            gridpane.getChildren().add(toggleButton);
        }
        gridpane.getChildren().addAll(labels);
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        setBottom(gridpane);
        setMargin(gridpane, new Insets(0, 15, 50, 15));
        handleEvents();
    }

    private void handleEvents() {
        for(int t = 0; t < lettersGroup.getToggles().size(); t++){
            ToggleButton selectedToggle = (ToggleButton) lettersGroup.getToggles().get(t);
            selectedToggle.setOnAction(actionEvent -> {
                String selectedText = selectedToggle.getText().trim();
                char correctAnswer = (char) (Integer.parseInt(new String(row.get(5)))-1+65);
                answerFound = correctAnswer == selectedText.charAt(0);
                Platform.exit();
            });
        }
    }
}
