package be.ugent.flash.handlers;

import be.ugent.flash.cardspanes.*;
import be.ugent.flash.command.*;
import be.ugent.flash.command.rights.AnswerChoice;
import be.ugent.flash.command.rights.AnswerChoiceImage;
import be.ugent.flash.command.rights.AnswerChoiceTextField;

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
            AnswerChoice answerChoice = getAnswerChoice();
            answerChoice.putInGridpane(partData, position);
            position += 1;
        }
        centerTitledPane.getMainGridpane().setRowPosition(position);
    }

    public AnswerChoice getAnswerChoice(){
        AnswerChoice choice;
        if(questionType.equals("mci")){
            choice = new AnswerChoiceImage(titledPaneGridpane);
        } else {
            choice = new AnswerChoiceTextField(titledPaneGridpane);
        }
        return choice;
    }

    public TitledPaneGridpane getTitledPaneGridpane() {
        return titledPaneGridpane;
    }
}