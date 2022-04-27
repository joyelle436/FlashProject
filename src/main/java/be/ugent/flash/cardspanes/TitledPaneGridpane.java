package be.ugent.flash.cardspanes;

import javafx.scene.layout.GridPane;


public class TitledPaneGridpane extends GridPane {

    private CenterTitledPane titledPane;
    private final OptionButton optionButton;
    private final String questionType;
    private int rowPosition;
    public TitledPaneGridpane(CenterTitledPane titledPane, String questionType){
        this.optionButton = new OptionButton(this);
        setGridLinesVisible(true);
        this.questionType = questionType;
        getChildren().add(optionButton);
        setVgap(7);
        this.rowPosition = 1;
    }

    public String getQuestionType() {
        return questionType;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }

    public OptionButton getOptionButton() {
        return optionButton;
    }
}
