package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * mcc
 */
public class Compact extends Type {

    private GridPane gridpane;
    public Compact(Stage stage, String DATA, String[] row) {
        super(stage, DATA, row);
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(22.5));
        gridpane = new GridPane();
        gridpane.setId("anchorpane");
        ToggleButton firstletter = new ToggleButton("Adfk,kdfng");
        firstletter.setId("togglebutton");
        ToggleButton secondletter = new ToggleButton("Bien fait");
        secondletter.setId("togglebutton");
        ToggleButton thirdletter = new ToggleButton("C");
        thirdletter.setId("togglebutton");
        gridpane.layout();
        ToggleGroup lettersGroup = new ToggleGroup();
        lettersGroup.getToggles().addAll(firstletter, secondletter, thirdletter);
        GridPane.setConstraints(firstletter, 0, 0);
        GridPane.setConstraints(secondletter, 1, 0);
        GridPane.setConstraints(thirdletter, 2, 0);
        gridpane.getChildren().addAll(firstletter, secondletter, thirdletter);
        gridpane.setHgap(10);
        setBottom(gridpane);
        setMargin(gridpane, new Insets(0, 15, 50, 15));
        setMargin(textFlow, new Insets(50, 15, 0, 15));
    }

    @Override
    public void addImage() {

    }

    @Override
    public void getAnswers() {

    }

    @Override
    public void addAnswers() {

    }
}
