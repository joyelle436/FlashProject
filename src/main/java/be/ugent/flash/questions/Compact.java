package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * mcc
 */
public class Compact extends Type {

    private final byte[] aByte;
    public Compact(Stage stage, String DATA, String[] row, List<String[]> answers, byte[] aByte) {
        super(stage, DATA, row, answers, aByte);
        this.aByte = aByte;
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(22.5));
        GridPane gridpane = new GridPane();
        gridpane.setId("anchorpane");
        ToggleGroup lettersGroup = new ToggleGroup();
        for(int i = 0; i < answersSize; i++){
            ToggleButton toggleButton = new ToggleButton(answers.get(i)[1]);
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
        setMargin(textFlow, new Insets(50, 15, 0, 15));
    }
}
