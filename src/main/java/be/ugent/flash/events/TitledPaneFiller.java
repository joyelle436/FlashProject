package be.ugent.flash.events;

import be.ugent.flash.cardspanes.*;
import be.ugent.flash.command.*;
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
        if(!questionType.equals("mci")){
            for(int i = 0; i < partDataList.size(); i++){
                PartData partData = partDataList.get(i);
                AnswerChoiceTextField choiceTextField = new AnswerChoiceTextField();
                choiceTextField.putInGridpane(partData, titledPaneGridpane, i+1);
            }
        } else {
            for(int j = 0; j < partDataList.size(); j++){
                PartData partData = partDataList.get(j);
                AnswerChoiceImage answerChoiceImage = new AnswerChoiceImage();
                answerChoiceImage.putInGridpane(partData, titledPaneGridpane, j+1);
            }
        }
    }
}