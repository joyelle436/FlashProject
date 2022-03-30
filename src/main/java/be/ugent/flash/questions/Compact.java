package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;

/**
 * mcc
 */
public class Compact extends Type {

    public Compact(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers) {
        super(stage, row, answers);
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(22.5));
        GridPane gridpane = new GridPane();
        gridpane.setId("anchorpane");
        ToggleGroup lettersGroup = new ToggleGroup();
        for(int i = 0; i < answers.size(); i++){
            ToggleButton toggleButton = new ToggleButton(new String(answers.get(new ArrayList<>(answers.keySet()).get(i))));
            toggleButton.setId("togglebutton");
            GridPane.setConstraints(gridpane, i, 0);
            GridPane.setConstraints(toggleButton, gridpane.getColumnCount()+1, 0);
            lettersGroup.getToggles().add(toggleButton);
            gridpane.getChildren().add(toggleButton);
        }
        gridpane.layout();
        gridpane.setHgap(5);
        setBottom(gridpane);
        setMargin(gridpane, new Insets(0, 15, 50, 15));
    }
}
