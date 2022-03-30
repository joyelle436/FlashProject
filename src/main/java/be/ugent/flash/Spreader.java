package be.ugent.flash;

import be.ugent.flash.factories.*;
import be.ugent.flash.questions.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

/**
 * Dit klasse verdeelt elke type vraag in een bepaalde klasse
 */

public class Spreader {

    private final Stage stage;
    private final List<List<byte[]>> questions;
    private final Map<Integer, Map<Integer, byte[]>> answers;
    private final Map<String, QuestionFactory> factoryMap;
    private Deque<Type> questionsOrder;
    private boolean quizDone;

    public Spreader(Stage stage, List<List<byte[]>> questions, Map<Integer, Map<Integer, byte[]>> answers){
        this.stage = stage;
        this.questions = questions;
        this.answers = answers;
        this.factoryMap = Map.of(
                "mcs", new StandardFactory(),
                "mcc", new CompactFactory(),
                "mci", new PictureFactory(),
                "mr", new MultipleFactory(),
                "open", new OpenStrFactory(),
                "openi", new OpenIntFactory()
        );
        this.questionsOrder = new ArrayDeque<>();
        this.quizDone = false;
    }

    public void divideQuestions() throws IOException {
        for(List<byte[]> row: questions){
            String questionType = new String(row.get(4));
            Integer id = Integer.parseInt(new String(row.get(0)));
            Type quiz = factoryMap.get(questionType).makeQuiz(stage, row, answers.get(id));
            questionsOrder.add(quiz);
        }
        List<Type> typelist;
        int i = 0;
        while (!quizDone){
            typelist = new ArrayList<>(questionsOrder);
            Type typeQuestion = typelist.get(i);
            typeQuestion.build();
            typeQuestion.showQuestion();//maakt een nieuwe scene met aan en plaats dit aan de stage
            while(!typeQuestion.canGoToNext()){
                //stopt als het antwoord gegeven wordt
            }
            if(typeQuestion.isAnswerFound()){
                questionsOrder.remove(typeQuestion);
            }
            quizDone = questionsOrder.isEmpty();
            i++;
        }
    }
}
