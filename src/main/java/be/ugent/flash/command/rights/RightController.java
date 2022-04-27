package be.ugent.flash.command.rights;


import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.command.PartData;
import be.ugent.flash.command.QuestionData;
import be.ugent.flash.command.SidePaneConnnection;

import java.util.List;

public class RightController {
    private final RightSidePane rightSidePane;
    private final RightPaneContent rightPaneData;
    private SidePaneConnnection mainController;
    private final List<PartData> partDataList;
    private final CommandMapMaker mapMaker;
    public RightController(SidePaneConnnection controller, List<PartData> partDataList){
        this.mainController = controller;
        this.rightSidePane = new RightSidePane(this);
        this.partDataList = partDataList;
        rightSidePane.fillRightPane();
        this.rightPaneData = new RightPaneContent();
        rightSidePane.setRightPaneContent(rightPaneData);
        this.mapMaker = new CommandMapMaker();
        mapMaker.makePartDataMap(partDataList);
    }

    public SidePaneConnnection getMainController() {
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
