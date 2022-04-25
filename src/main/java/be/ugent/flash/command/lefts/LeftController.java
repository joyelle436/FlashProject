package be.ugent.flash.command.lefts;

import be.ugent.flash.command.QuestionData;
import be.ugent.flash.command.SidePaneController;
import be.ugent.flash.command.lefts.LeftSidePane;

import java.util.List;

public class LeftController {

    private final LeftSidePane leftSidePane;
    private final List<QuestionData> questionDataList;
    public LeftController(SidePaneController controller, List<QuestionData> questionDataList){
        this.leftSidePane = new LeftSidePane(controller);
        leftSidePane.fillLeftPane(questionDataList);
        this.questionDataList = questionDataList;
    }

    public List<QuestionData> getQuestionDataList() {
        return questionDataList;
    }

    public LeftSidePane getLeftSidePane() {
        return leftSidePane;
    }

}
