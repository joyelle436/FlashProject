package be.ugent.flash.command;

import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.cardspanes.CardPane;

/**
 * Gebruikt door {@link RightController} om data aan de rechterkant toe te voegen
 */
public class RightPaneContent {
    private final CommandMapMaker mapMaker;
    private RightSidePane rightSidePane;
    public RightPaneContent(){
        this.mapMaker = new CommandMapMaker();
        mapMaker.makePanesMap();
    }

    public void setRightSidePane(RightSidePane rightSidePane) {
        this.rightSidePane = rightSidePane;
    }

    public void addPartsContents(QuestionData questionData){
        rightSidePane.getTopGridpane().setVisible(true);
        rightSidePane.getTopGridpane().addToTopContent(questionData);
        CardPane pane = mapMaker.getQuestionPane(questionData.getQuestionType());
        pane.setRightSidePane(rightSidePane);
        pane.fill();
        pane.setCorrectTextField(questionData.getCorrectAnswer());
        rightSidePane.changeCenterChild(pane);
    }
}