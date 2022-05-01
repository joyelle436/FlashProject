package be.ugent.flash.command.rights;

import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.cardspanes.CardPane;
import be.ugent.flash.data.Part;
import be.ugent.flash.data.Question;

import java.util.*;

/**
 * Gebruikt door {@link RightController} om data aan de rechterkant toe te voegen
 */
public class RightPaneContent {
    private final CommandMapMaker mapMaker;
    private RightSidePane rightSidePane;
    private Question question;
    private CardPane pane;
    public RightPaneContent() {
        this.mapMaker = new CommandMapMaker();
        mapMaker.makePanesMap();
    }

    public void setRightSidePane(RightSidePane rightSidePane) {
        this.rightSidePane = rightSidePane;
    }

    public void addContents(Question question, String type) {
        this.question = question;
        addQuestionContent();
        if(!(type.equals("open") || type.equals("openi"))){
            addPartsContent(type);
        }
    }

    private void addQuestionContent() {
        rightSidePane.getTopGridpane().setVisible(true);
        rightSidePane.getTopGridpane().addToTopContent(question);
        this.pane = mapMaker.getQuestionPane(question.questionType());
        pane.setQuestion(question);
        pane.setRightSidePane(rightSidePane);
        pane.setCorrectTextField(question.correctAnswer());
        rightSidePane.changeCenterChild(pane);
    }

    private void addPartsContent(String type){
        /* Lijst met alle parts uit databank */
        List<Part> parts = rightSidePane.getRightController().getMainController().showPartsContent(question.id());
        int position = 1;
        for(Part part: parts){
            AnswerChoiceObject answerChoiceObject;
            if(type.equals("mci")){
                answerChoiceObject = new AnswerChoiceImage(pane.getTitledPane().getMainGridpane());
            } else {
                answerChoiceObject = new AnswerChoiceTextField(pane.getTitledPane().getMainGridpane());
            }
            answerChoiceObject.putInGridpane(part, position);
            answerChoiceObject.gridpane.getOptionButton().increasePosition();
            answerChoiceObject.gridpane.setRowPosition(position+1);
            position += 1;
        }
    }
}