package be.ugent.flash.questions;

import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * mcs
 */
public class Standard extends Type {

    private VBox vBox;
    public Standard(Stage stage, String DATA, String[] row) {
        super(stage, DATA, row);
    }

    @Override
    public void build() {
        super.build();
        text.setFont(new Font(22.5));
        vBox = new VBox();
        ToggleButton firstletter = new ToggleButton("A");
        firstletter.setId("togglebutton");
        ToggleButton secondletter = new ToggleButton("B");
        secondletter.setId("togglebutton");
        ToggleButton thirdletter = new ToggleButton("C");
        thirdletter.setId("togglebutton");
        ToggleGroup lettersGroup = new ToggleGroup();
        lettersGroup.getToggles().addAll(firstletter, secondletter, thirdletter);
        vBox.getChildren().addAll(firstletter, secondletter, thirdletter);
        vBox.setSpacing(5);
        setBottom(vBox);
        setMargin(vBox, new Insets(0, 15, 50, 15));
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
