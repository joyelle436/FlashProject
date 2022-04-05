package be.ugent.flash;

import be.ugent.flash.factories.*;
import be.ugent.flash.cards.*;
import be.ugent.flash.visitors.*;
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
    private final Map<String, CardVisitor> cardVisitorMap;

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
        this.cardVisitorMap = Map.of(
                "mcs", new StandardCardVisitor(),
                "mcc", new CompactCardVisitor(),
                "mci", new PictureCardVisitor(),
                "mr", new MultipleCardVisitor(),
                "open", new OpenQuestionVisitor(),
                "openi", new OpenQuestionVisitor()

        );
    }

    public void divideQuestions() throws IOException {
        Deque<Type> cardsQueue = new ArrayDeque<>();
        for(List<byte[]> question: questions){
            Integer id = Integer.parseInt(new String(question.get(0)));
            QuestionFactory factory = factoryMap.get(new String(question.get(4)));
            Type type = factory.makeQuiz(stage, question, answers.get(id), null);
            CardVisitor cardVisitor = cardVisitorMap.get(new String(question.get(4)));
            cardVisitor.buildCard(type);
            cardsQueue.add(type);
        }

        List<Type> cards = new ArrayList<>(cardsQueue);
        for(int i = 0; i < cards.size()-1; i++){
            cards.get(i).setNextCard(cards.get(i+1));
        }
        cards.get(0).showQuestion();
    }
}