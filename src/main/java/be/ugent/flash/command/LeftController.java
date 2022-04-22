package be.ugent.flash.command;

import java.util.List;

public class LeftController {

    private final LeftSidePane leftSidePane;
    private final List<QuestionData> questionDataList;
    public LeftController(SidePaneController controller, List<QuestionData> questionDataList){
        this.leftSidePane = new LeftSidePane(controller);
        leftSidePane.fillLeftPane(questionDataList);
        this.questionDataList = questionDataList;
    }

    public LeftSidePane getLeftSidePane() {
        return leftSidePane;
    }

}
