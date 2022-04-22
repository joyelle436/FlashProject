package be.ugent.flash;

import be.ugent.flash.data.Part;
import be.ugent.flash.data.Question;
import be.ugent.flash.viewer.factories.*;
import be.ugent.flash.viewer.visitors.*;

import java.util.*;

/**
 * Houd Maps van types vragen bij en hun corresponderende factories, visitors, ...
 */
public class ViewerMapMaker {
    private Map<String, TypeFactory> factoryMap;
    private Map<String, CardVisitor> cardVisitorMap;
    private final Map<Integer, List<Part>> partsMap;
    public ViewerMapMaker(){
        this.partsMap = new HashMap<>();
    }

    public void makePartMap(List<Part> list){
        for(Part part: list){
            if(!partsMap.containsKey(part.question_id())){
                partsMap.put(part.question_id(), new ArrayList<>());
            }
            partsMap.get(part.question_id()).add(part);
        }
    }
    public void makeFactoryMap(){
        this.factoryMap = Map.of(
                "mcs", new StandardFactory(),
                "mcc", new CompactFactory(),
                "mci", new PictureFactory(),
                "mr", new MultipleFactory(),
                "open", new OpenStrFactory(),
                "openi", new OpenIntFactory()
        );
    }
    public void makeVisitorMap(){
        this.cardVisitorMap = Map.of(
                "mcs", new StandardCardVisitor(),
                "mcc", new CompactCardVisitor(),
                "mci", new PictureCardVisitor(),
                "mr", new MultipleCardVisitor(),
                "open", new OpenQuestionVisitor(),
                "openi", new OpenQuestionVisitor()

        );
    }

    public List<Part> getPart(Integer key){
        return partsMap.get(key);
    }
    public TypeFactory getFactory(String key){
        return factoryMap.get(key);
    }
    public CardVisitor getVisitor(String key){
        return cardVisitorMap.get(key);
    }
}