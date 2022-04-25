package be.ugent.flash.cardspanes;

import javafx.scene.layout.GridPane;

public class TitledPaneGridpane extends GridPane {

    private CenterTitledPane titledPane;
    private final OptionButton optionButton;
    public TitledPaneGridpane(CenterTitledPane titledPane){
        this.optionButton = new OptionButton();
        getChildren().add(optionButton);
        setVgap(7);
    }

    public OptionButton getOptionButton() {
        return optionButton;
    }

}
