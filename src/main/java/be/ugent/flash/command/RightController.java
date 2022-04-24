package be.ugent.flash.command;


import java.util.List;

public class RightController {
    private final RightSidePane rightSidePane;
    private final RightPaneContent rightPaneData;
    public RightController(SidePaneController controller){
        this.rightSidePane = new RightSidePane(controller);
        rightSidePane.fillRightPane();
        this.rightPaneData = new RightPaneContent();
        rightSidePane.setRightPaneContent(rightPaneData);
    }

    public RightSidePane getRightSidePane() {
        return rightSidePane;
    }

    public void showContent(QuestionData questionData, List<PartData> partDataList){
        rightPaneData.addContents(questionData, partDataList);
    }
}
