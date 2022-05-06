package be.ugent.flash.command.right;

import be.ugent.flash.command.CommandMapMaker;
import be.ugent.flash.cardspanes.CardPane;
import be.ugent.flash.data.Part;
import be.ugent.flash.data.Question;

import java.util.*;

/**
 * Gebruikt door {@link RightController} om data aan de rechterkant toe te voegen
 */
public class RightPaneContent {
    private final CommandMapMaker commandMapMaker;
    private RightSidePane rightSidePane;
    private Question question;
    private CardPane pane;
    public RightPaneContent() {
        this.commandMapMaker = new CommandMapMaker();
        commandMapMaker.makePanesMap();
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
        this.pane = commandMapMaker.getQuestionPane(question.questionType());
        pane.setQuestion(question);
        pane.setRightSidePane(rightSidePane);
        rightSidePane.changeCenterChild(pane);
    }

    private void addPartsContent(String type){
        /* Lijst met alle parts uit databank */
        List<Part> parts = rightSidePane.getRightController().getMainController().showPartsContent(question.id());
        /* Voor een nieuwe toegevoegd vraag */
        if(parts.isEmpty()){
            question = new Question(question.id(), question.title(), question.text(),
                    question.middleImage(), question.questionType(), "0");
            parts.add(new Part(question.id(), Integer.MAX_VALUE, null));
        }
        int position = 1;
        for(Part part: parts){
            AnswerChoiceObject answerChoiceObject;
            if(type.equals("mci")){
                answerChoiceObject = new AnswerChoiceImage(pane.getTitledPane().getMainGridpane());
                answerChoiceObject.setNewImagePart(part.part());
            } else if(type.equals("mcc")){
                answerChoiceObject = new AnswerChoiceTextField(pane.getTitledPane().getMainGridpane());
            } else {
                answerChoiceObject = new AnswerChoiceTextArea(pane.getTitledPane().getMainGridpane());
            }
            answerChoiceObject.putInGridpane(part, position);
            answerChoiceObject.gridpane.setRowPosition(position+1);
            position += 1;
        }
        if(question.correctAnswer().length() >= 1){
            pane.getTitledPane().getMainGridpane().select(question);
        }
    }
}