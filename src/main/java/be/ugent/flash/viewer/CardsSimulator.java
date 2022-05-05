package be.ugent.flash.viewer;

import be.ugent.flash.ViewerMapMaker;
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
        ViewerMapMaker viewerMapMaker = new ViewerMapMaker();
        viewerMapMaker.makeFactoryMap();
        viewerMapMaker.makeVisitorMap();
        viewerMapMaker.makePartMap(partList);
        LinkedList<Type> typeLinkedList = new LinkedList<>();
        CardModel model = new CardModel();

        /*
        De kaarten aanmaken en model toevoegen
         */
        for(Question question: questionList){
            Type type = viewerMapMaker.getFactory(question.questionType()).makeCard(stage, question);
            List<Part> parts = viewerMapMaker.getPart(type.getQuestionRow().id());
            if(parts != null){
                parts.removeIf(part -> part.part() == null);
                type.setAnswers(parts);
            }
            //noinspection unchecked
            viewerMapMaker.getVisitor(question.questionType()).buildCard(type);
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