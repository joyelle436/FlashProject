package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * mcs
 */
public class Standard extends Type {

    private GridPane gridpane;
    public Standard(Stage stage, String DATA, String[] row) {
        super(stage, DATA, row);
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(22.5));
        gridpane = new GridPane();
        gridpane.setId("anchorpane");
        ToggleButton firstletter = new ToggleButton(" A ");
        firstletter.setId("togglebutton");
        Label firstletterlabel = new Label("A text");
        firstletterlabel.setId("label");
        ToggleButton secondletter = new ToggleButton(" B ");
        secondletter.setId("togglebutton");
        Label secondletterlabel = new Label("B text");
        secondletterlabel.setId("label");
        ToggleButton thirdletter = new ToggleButton(" C ");
        thirdletter.setId("togglebutton");
        Label thirdletterlabel = new Label("C text");
        thirdletterlabel.setId("label");
        ToggleGroup lettersGroup = new ToggleGroup();
        lettersGroup.getToggles().addAll(firstletter, secondletter, thirdletter);
        GridPane.setConstraints(firstletter, 0, 0);
        GridPane.setConstraints(secondletter, 0, 1);
        GridPane.setConstraints(thirdletter, 0, 2);
        GridPane.setConstraints(firstletterlabel, 1, 0);
        GridPane.setConstraints(secondletterlabel, 1, 1);
        GridPane.setConstraints(thirdletterlabel, 1, 2);
        gridpane.getChildren().addAll(firstletter, secondletter, thirdletter);
        gridpane.getChildren().addAll(firstletterlabel, secondletterlabel, thirdletterlabel);
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        setBottom(gridpane);
        setMargin(gridpane, new Insets(0, 15, 50, 15));
        setMargin(textFlow, new Insets(50, 15, 0, 15));
    }

    @Override
    public void addImage(){

    }

    @Override
    public void getAnswers(){

    }

    @Override
    public void addAnswers(){

    }
}
