package be.ugent.flash.cardspanes;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.HashSet;
import java.util.Set;

public class TitledPaneGridpane extends GridPane {

    private CenterTitledPane titledPane;
    private final OptionButton optionButton;
    private final String questionType;
    private int rowPosition;
    private Set<PositionChanger> positionChangerSet;
    public TitledPaneGridpane(CenterTitledPane titledPane, String questionType){
        this.optionButton = new OptionButton(this);
        this.positionChangerSet = new HashSet<>();
        positionChangerSet.add(optionButton);
        setGridLinesVisible(true);
        this.questionType = questionType;
        getChildren().add(optionButton);
        setVgap(7);
        this.rowPosition = 1;
    }

    public void removeFromSet(PositionChanger positionChanger){
        int row = GridPane.getRowIndex((Node) positionChanger);
        positionChangerSet.remove(positionChanger);
        for(PositionChanger changer: positionChangerSet){
            //changer.changePosition(row);
        }
        System.out.println();
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
