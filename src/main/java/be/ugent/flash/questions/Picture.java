package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * mci
 */
public class Picture extends Type {
    private final GridPane gridpane;
    //key togglebutton, value: antwoord part id
    private final Map<ToggleButton, Integer> toggleAnswers;
    public Picture(Stage stage, List<byte[]> row, Map<Integer, byte[]> answers) {
        super(stage, row, answers);
        gridpane = new GridPane();
        toggleAnswers = new HashMap<>();
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(22.5));
        int i = 0;
        ToggleGroup group = new ToggleGroup();
        for(Integer key: answers.keySet()){
            Image answerImage = new Image(new ByteArrayInputStream(answers.get(key)));
            ToggleButton toggleButton = new ToggleButton();
            toggleButton.setGraphic(new ImageView(answerImage));
            toggleAnswers.put(toggleButton, key);
            GridPane.setConstraints(toggleButton, i, 0);
            GridPane.setConstraints(toggleButton, gridpane.getColumnCount()+1, 0);
            group.getToggles().add(toggleButton);
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
            setMargin(gridpane, new Insets(25, 15, 50, 30));
        }
    }
}
