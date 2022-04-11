package be.ugent.flash;

import be.ugent.flash.cards.CardModel;
import be.ugent.flash.cards.Type;
import javafx.stage.Stage;

import java.util.*;

//vragen p2@ugent.be
/**
 * Dit klasse maakt de kaarten aan van elke type vraag en geeft een lijst ervan
 * aan de model {@link CardModel} die de simulatie gaat doen
 */

public class Simulator {

    private final Stage stage;
    private final List<QuestionRow> rows;
    private final Map<Integer, Map<Integer, byte[]>> answers;

    public Simulator(Stage stage, List<QuestionRow> rows, Map<Integer, Map<Integer, byte[]>> answers){
        this.stage = stage;
        this.rows = rows;
        this.answers = answers;
    }

    public void divideQuestions(){
        Maker maker = new Maker();
        LinkedList<Type> typeLinkedList = new LinkedList<>();
        CardModel model = new CardModel();
        for (QuestionRow row : rows) {
            Type type = maker.makeFactory((row.questionType())).makeCard(stage, row, answers.get(row.id()));
            //noinspection unchecked
            maker.makeVisitor((row.questionType())).buildCard(type);
            type.setModel(model);
            typeLinkedList.add(type);
        }
        for(int i = 0; i < typeLinkedList.size()-1; i++){
            typeLinkedList.get(i).setNextCard(typeLinkedList.get(i+1));
        }
        model.setCardsList(typeLinkedList);
        /*
        Toont de eerst kaart op de stage en de rest volgt
         */
        typeLinkedList.getFirst().showQuestion();
    }
}