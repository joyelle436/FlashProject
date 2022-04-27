package be.ugent.flash.command.rights;

import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.cardspanes.CardPane;
import be.ugent.flash.command.PartData;
import be.ugent.flash.command.QuestionData;

import java.util.*;

/**
 * Gebruikt door {@link RightController} om data aan de rechterkant toe te voegen
 */
public class RightPaneContent {
    private final CommandMapMaker mapMaker;
    private RightSidePane rightSidePane;
    private QuestionData questionData;
    private List<PartData> partDataList;
    private final Map<Integer, CardPane> cardPaneMap;
    public RightPaneContent(){
        this.cardPaneMap = new HashMap<>();
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
        CardPane pane;
        if(cardPaneMap.containsKey(questionData.getId())){
            pane = cardPaneMap.get(questionData.getId());
        } else {
            pane = mapMaker.getQuestionPane(questionData.getQuestionType());
            pane.setRightSidePane(rightSidePane, partDataList);
            pane.setCorrectTextField(questionData.getCorrectAnswer());
            cardPaneMap.put(questionData.getId(), pane);
        }
        rightSidePane.changeCenterChild(pane);
    }
}