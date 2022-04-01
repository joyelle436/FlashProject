package be.ugent.flash;

import be.ugent.flash.factories.*;
import be.ugent.flash.questions.*;
import be.ugent.flash.visitors.CompactCardVisitor;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        for (List<byte[]> row : questions) {
            String questionType = new String(row.get(4));
            Integer id = Integer.parseInt(new String(row.get(0)));
            Type quiz = factoryMap.get(questionType).makeQuiz(stage, row, answers.get(id), null);
            questionsOrder.add(quiz);
        }

        List<Type> typelist = new ArrayList<>(questionsOrder);
        for(int t = 0; t < typelist.size()-1; t++){
            typelist.get(t).setNextCard(typelist.get(t+1));
        }
        Integer id = Integer.parseInt(new String(questions.get(1).get(0)));
        CompactCard compactCard = new CompactCard(stage, questions.get(1), answers.get(id), null);
        compactCard.showQuestion();
    }
}
