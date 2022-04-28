package be.ugent.flash.command;

import be.ugent.flash.CommandMapMaker;
import be.ugent.flash.data.*;

import java.sql.SQLException;
import java.util.*;

/**
 * Start linkerkant en vervolgens rechterkant aan
 */
public class PaneStarter {
    public PaneStarter(MainBorderPane startWindow, Map<Integer, String[]> questionMap, String database) throws SQLException {
        CommandMapMaker mapMaker = new CommandMapMaker();
        //mapMaker.makeIdMap(questionList);
        List<QuestionData> questionDataList = new ArrayList<>();
//        for(Question question: questionList){
//            QuestionData qData = new QuestionData(question.id(), question.title(), question.text(),
//                    question.middleImage(), question.questionType(), question.correctAnswer());
//            questionDataList.add(qData);
//        }

        new SidePaneConnection(startWindow, questionMap, database).showPanes();
    }
}