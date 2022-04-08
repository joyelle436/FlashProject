package be.ugent.flash;

import be.ugent.flash.cards.Type;
import be.ugent.flash.factories.*;
import be.ugent.flash.visitors.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

//vragen p2@ugent.be
/**
 * Dit klasse verdeelt elke type vraag in een bepaalde klasse
 */

public class Simulator {

    private final Stage stage;
    private final List<QuestionRow> rows;
    private final Map<Integer, Map<Integer, byte[]>> answers;
    private final Map<String, QuestionFactory> factoryMap;
    private final Map<String, CardVisitor> cardVisitorMap;

    public Simulator(Stage stage, List<QuestionRow> rows, Map<Integer, Map<Integer, byte[]>> answers){
        this.stage = stage;
        this.rows = rows;
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
        LinkedList<Type> typeLinkedList = new LinkedList<>();
        for (QuestionRow row : rows) {
            Type type = factoryMap.get(row.questionType()).makeCard(stage, row, answers.get(row.id()));
            cardVisitorMap.get(row.questionType()).buildCard(type);
            typeLinkedList.add(type);
        }
        CardModel model = new CardModel();
        for(Type type: typeLinkedList){
            type.setModel(model);
        }
        for(int i = 0; i < typeLinkedList.size()-1; i++){
            typeLinkedList.get(i).setNextCard(typeLinkedList.get(i+1));
        }
        model.setCardsList(typeLinkedList);
        typeLinkedList.getFirst().showQuestion();
    }
}