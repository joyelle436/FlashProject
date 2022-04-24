package be.ugent.flash.command;

import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.cardspanes.CardPane;

import java.util.List;

/**
 * Gebruikt door {@link RightController} om data aan de rechterkant toe te voegen
 */
public class RightPaneContent {
    private final CommandMapMaker mapMaker;
    private RightSidePane rightSidePane;
    private QuestionData questionData;
    private List<PartData> partDataList;
    public RightPaneContent(){
        this.mapMaker = new CommandMapMaker();
        mapMaker.makePanesMap();
    }

    public void setRightSidePane(RightSidePane rightSidePane) {
        this.rightSidePane = rightSidePane;
    }

    public void addContents(QuestionData questionData, List<PartData> partDataList){
        this.questionData = questionData;
        this.partDataList = partDataList;
        addQuestionContent();
    }

    private void addQuestionContent(){
        rightSidePane.getTopGridpane().setVisible(true);
        rightSidePane.getTopGridpane().addToTopContent(questionData);
        CardPane pane = mapMaker.getQuestionPane(questionData.getQuestionType());
        pane.setRightSidePane(rightSidePane, partDataList);
        pane.fill();
        pane.setCorrectTextField(questionData.getCorrectAnswer());
        rightSidePane.changeCenterChild(pane);
    }

    private void addPartContent(){

    }
}