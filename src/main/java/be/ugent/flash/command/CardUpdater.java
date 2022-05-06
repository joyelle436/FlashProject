package be.ugent.flash.command;

import be.ugent.flash.cardspanes.CardPane;
import be.ugent.flash.command.right.*;
import be.ugent.flash.data.*;

import java.sql.SQLException;
import java.util.*;

public class CardUpdater {

    private final CardPane cardPane;
    private final List<Part> partList;
    private final Random RD;

    public CardUpdater(CardPane cardPane) {
        this.cardPane = cardPane;
        this.partList = new ArrayList<>();
        this.RD = new Random();
    }

    public List<Part> getPartList() {
        return partList;
    }

    public Question getUpdatedQuestion(boolean preview) throws SQLException {
        String[] questionTopContent = cardPane.getRightSidePane().getTopGridpane().getTopContent().getQuestionTopContent();
        byte[] middleImage = cardPane.getRightSidePane().getTopGridpane().getTopContent().getMiddleImage();
        /* De afbeelding werd niet gewijzigd */
        if (middleImage != null && middleImage.length == 0) {
            middleImage = cardPane.getQuestion().middleImage();
        }
        Question updatedQuestion = new Question(cardPane.getQuestion().id(), questionTopContent[0], questionTopContent[1],
                middleImage, cardPane.getQuestion().questionType(), cardPane.getCorrect());
        if (!cardPane.getQuestion().questionType().equals("open") && !cardPane.getQuestion().questionType().equals("openi")) {
            updateCardParts(preview);
        }
        return updatedQuestion;
    }

    public void updateCardParts(boolean preview) throws SQLException {
        Queue<AnswerChoiceObject> choiceObjectQueue = cardPane.getTitledPane().getMainGridpane().getChoiceObjectQueue();
        if (cardPane.getQuestion().questionType().equals("mci")) {
            updateImageParts(choiceObjectQueue, preview);
        } else {
            updateStringParts(choiceObjectQueue, preview);
        }
    }

    private void updateStringParts(Queue<AnswerChoiceObject> choiceObjectQueue, boolean preview) throws SQLException {
        for (AnswerChoiceObject choiceObject : choiceObjectQueue) {
            if (preview) {
                partList.add(new Part(cardPane.getQuestion().id(), RD.nextInt(10), choiceObject.getStringPart()));
            } else {
                if (choiceObject.getIdPart() < Integer.MAX_VALUE) {
                    cardPane.getDatabaseUpdater().updatePart(cardPane.getQuestion().id(), choiceObject.getIdPart(), choiceObject.getStringPart());
                } else {
                    cardPane.getDatabaseUpdater().addNewPart(cardPane.getQuestion().id(), choiceObject.getStringPart());
                }
            }
        }
    }

    private void updateImageParts(Queue<AnswerChoiceObject> choiceObjectQueue, boolean preview) throws SQLException {
        for (AnswerChoiceObject choiceObject : choiceObjectQueue) {
            AnswerChoiceImage choiceImage = (AnswerChoiceImage) choiceObject;
            if (preview) {
                partList.add(new Part(cardPane.getQuestion().id(), RD.nextInt(10), choiceImage.getImagePath()));
            } else {
                if (choiceImage.getIdPart() < Integer.MAX_VALUE) {
                    cardPane.getDatabaseUpdater().updatePart(cardPane.getQuestion().id(), choiceImage.getIdPart(), choiceImage.getImagePath());
                } else {
                    cardPane.getDatabaseUpdater().addNewPart(cardPane.getQuestion().id(), choiceImage.getImagePath());
                }
            }
        }
    }
}