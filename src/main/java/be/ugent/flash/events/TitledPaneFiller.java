package be.ugent.flash.events;

import be.ugent.flash.cardspanes.CenterTitledPane;
import be.ugent.flash.cardspanes.TitledPaneGridpane;
import be.ugent.flash.command.AnswerChoiceTextField;
import be.ugent.flash.command.PartData;

import java.util.List;

public class TitledPaneFiller {

    private CenterTitledPane centerTitledPane;
    private List<PartData> partDataList;
    private TitledPaneGridpane titledPaneGridpane;
    private String questionType;

    public TitledPaneFiller(CenterTitledPane centerTitledPane, List<PartData> partDataList, String questionType){
        this.centerTitledPane = centerTitledPane;
        this.partDataList = partDataList;
        this.titledPaneGridpane = centerTitledPane.getMainGridpane();
        this.questionType = questionType;
    }

    public void fillParts() {
        if(!questionType.equals("mci")){
            int i = 1;
            for(PartData partData: partDataList){
                AnswerChoiceTextField choiceTextField = new AnswerChoiceTextField();
                choiceTextField.addText(new String(partData.getPart()));
                choiceTextField.setPosition(i);
                titledPaneGridpane.getChildren().add(choiceTextField);
                titledPaneGridpane.getOptionButton().increasePosition();
                i++;
            }
        }
    }
}
