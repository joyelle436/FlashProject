package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

/**
 * mcs
 */
public class Standard extends Type {

    private GridPane gridpane;
    private final Label[] labels;
    public Standard(Stage stage, String DATA, String[] row, List<String[]> answers, byte[] aByte) {
        super(stage, DATA, row, answers, aByte);
        labels = new Label[answersSize];
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(22.5));
        gridpane = new GridPane();
        gridpane.setId("anchorpane");
        ToggleGroup lettersGroup = new ToggleGroup();
        for(int i = 0; i < answersSize; i++){
            ToggleButton toggleButton = new ToggleButton(" " + ((char) (i+65)) + " ");
            toggleButton.setId("togglebutton");
            Label label = new Label(answers.get(i)[1]);
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
        setMargin(textFlow, new Insets(50, 15, 0, 15));
    }
}
