package be.ugent.flash.viewer;

import be.ugent.flash.MapMaker;
import be.ugent.flash.viewer.cards.*;
import be.ugent.flash.data.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * Dit klasse maakt de kaarten van elke type vraag aan
 */

public class CardsSimulator {

    private final List<Question> questionList;
    private final List<Part> partList;
    private final Stage stage;

    public CardsSimulator(Stage stage, List<Question> questionList, List<Part> partList){
        this.questionList = questionList;
        this.partList = partList;
        this.stage = stage;
    }

    public void showQuestions(){
        MapMaker maker = new MapMaker();
        maker.makeFactoryMap();
        maker.makeVisitorMap();
        maker.makePartMap(partList);
        LinkedList<Type> typeLinkedList = new LinkedList<>();
        CardModel model = new CardModel();

        /*
        Die kaarten aanmaken en model toevoegen
         */
        for(Question question: questionList){
            Type type = maker.getFactory(question.questionType()).makeCard(stage, question);
            List<Part> parts = maker.getPart(type.getQuestionRow().id());
            if(parts != null){
                type.setAnswers(parts);
            }
            //noinspection unchecked
            maker.getVisitor(question.questionType()).buildCard(type);
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