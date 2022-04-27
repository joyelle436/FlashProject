package be.ugent.flash.handlers;

import be.ugent.flash.cardspanes.*;
import be.ugent.flash.command.*;
import be.ugent.flash.command.rights.*;

import java.util.List;

public class TitledPaneFiller {

    private final CenterTitledPane centerTitledPane;
    private final List<PartData> partDataList;
    private final TitledPaneGridpane titledPaneGridpane;
    private final String questionType;

    public TitledPaneFiller(CenterTitledPane centerTitledPane, List<PartData> partDataList, String questionType){
        this.centerTitledPane = centerTitledPane;
        this.partDataList = partDataList;
        this.titledPaneGridpane = centerTitledPane.getMainGridpane();
        this.questionType = questionType;
    }

    public void fillParts() {
        int position = centerTitledPane.getMainGridpane().getRowPosition();
        for(PartData partData: partDataList) {
            AnswerChoiceObject choiceObject = getChoiceObject();
            choiceObject.putInGridpane(partData, position);
            position += 1;
        }
        centerTitledPane.getMainGridpane().setRowPosition(position);
    }

    public AnswerChoiceObject getChoiceObject(){
        AnswerChoiceObject choiceObject;
        if(questionType.equals("mci")){
            choiceObject = new AnswerChoiceImage(titledPaneGridpane);
        } else {
            choiceObject = new AnswerChoiceTextField(titledPaneGridpane);
        }
        return choiceObject;
    }

    public TitledPaneGridpane getTitledPaneGridpane() {
        return titledPaneGridpane;
    }
}