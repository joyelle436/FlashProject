package be.ugent.flash;

import be.ugent.flash.cards.*;
import be.ugent.flash.data.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * Dit klasse maakt de kaarten van elke type vraag aan
 */

public class Simulator {

    private final List<Question> questionList;
    private final List<Part> partList;
    private final Stage stage;

    public Simulator(Stage stage, List<Question> questionList, List<Part> partList){
        this.questionList = questionList;
        this.partList = partList;
        this.stage = stage;
    }

    public void showQuestions(){
        Maker maker = new Maker();
        LinkedList<Type> typeLinkedList = new LinkedList<>();
        CardModel model = new CardModel();

        Map<Integer, List<Part>> partsMap = new HashMap<>();
        for(Part part: partList){
            if(!partsMap.containsKey(part.question_id())){
                partsMap.put(part.question_id(), new ArrayList<>());
            }
            partsMap.get(part.question_id()).add(part);
        }
        /*
        Die kaarten aanmaken en model toevoegen
         */
        for(Question question: questionList){
            Type type = maker.makeFactory(question.questionType()).makeCard(stage, question);
            if(partsMap.containsKey(type.getQuestionRow().id())){
                type.setAnswers(partsMap.get(type.getQuestionRow().id()));
            }
            //noinspection unchecked
            maker.makeVisitor(question.questionType()).buildCard(type);
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