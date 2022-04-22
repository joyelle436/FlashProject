package be.ugent.flash.command;

import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.data.*;

import java.util.*;

/**
 * Start linkerkant en vervolgens rechterkant aan
 */
public class PaneStarter {

    public PaneStarter(MainBorderPane startWindow, List<Question> questionList, List<Part> partList){
        CommandMapMaker mapMaker = new CommandMapMaker();
        mapMaker.makeIdMap(questionList);
        List<QuestionData> questionDataList = new ArrayList<>();
        List<PartData> partDataList = new ArrayList<>();
        for(Question q: questionList){
            QuestionData qData = new QuestionData(q.id(), q.title(), q.text(), q.middleImage(), q.questionType(), q.correctAnswer());
            questionDataList.add(qData);
        }

        for(Part p: partList){
            if(mapMaker.getIdType(p.question_id()).equals("mci")){
                partDataList.add(new PictureCardPart(p.question_id(), p.part_id(), p.part()));
            } else {
                partDataList.add(new CardPart(p.question_id(), p.part_id(), p.part()));
            }
        }
        new SidePaneController(startWindow, questionDataList, partDataList).showPanes();
    }

}