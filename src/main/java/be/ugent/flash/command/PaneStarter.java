package be.ugent.flash.command;

import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.data.*;

import java.util.*;

/**
 * Start linkerkant en vervolgens rechterkant aan
 */
public class PaneStarter {
    public PaneStarter(MainBorderPane startWindow, List<Question> questionList, List<Part> partList, String database){
        CommandMapMaker mapMaker = new CommandMapMaker();
        mapMaker.makeIdMap(questionList);
        List<QuestionData> questionDataList = new ArrayList<>();
        List<PartData> partDataList = new ArrayList<>();
        for(Question question: questionList){
            QuestionData qData = new QuestionData(question.id(), question.title(), question.text(),
                    question.middleImage(), question.questionType(), question.correctAnswer());
            questionDataList.add(qData);
        }

        for(Part part: partList){
            if(mapMaker.getIdType(part.question_id()).equals("mci")){
                partDataList.add(new PictureCardPart(part.question_id(), part.part_id(), part.part()));
            } else {
                partDataList.add(new CardPart(part.question_id(), part.part_id(), part.part()));
            }
        }
        new SidePaneConnnection(startWindow, questionDataList, partDataList).showPanes(database);
    }

}