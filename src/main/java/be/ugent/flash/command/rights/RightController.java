package be.ugent.flash.command.rights;


import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.command.PartData;
import be.ugent.flash.command.QuestionData;
import be.ugent.flash.command.SidePaneController;

import java.util.List;

public class RightController {
    private final RightSidePane rightSidePane;
    private final RightPaneContent rightPaneData;
    private SidePaneController mainController;
    private final List<PartData> partDataList;
    private final CommandMapMaker mapMaker;
    public RightController(SidePaneController controller, List<PartData> partDataList){
        this.mainController = controller;
        this.rightSidePane = new RightSidePane(this);
        this.partDataList = partDataList;
        rightSidePane.fillRightPane();
        this.rightPaneData = new RightPaneContent();
        rightSidePane.setRightPaneContent(rightPaneData);
        this.mapMaker = new CommandMapMaker();
        mapMaker.makePartDataMap(partDataList);
    }

    public SidePaneController getMainController() {
        return mainController;
    }

    public RightSidePane getRightSidePane() {
        return rightSidePane;
    }

    public void showContent(QuestionData questionData){
        /* questionData + lijst van PartData voor die specifieke vraag*/
        rightPaneData.addContents(questionData, mapMaker.getPartData(questionData.getId()));
    }

    public List<PartData> getPartDataList() {
        return partDataList;
    }
}
