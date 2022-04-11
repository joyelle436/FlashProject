package be.ugent.flash;

import be.ugent.flash.cards.Type;
import be.ugent.flash.factories.*;
import be.ugent.flash.visitors.*;

import java.util.Map;

/**
 * Houd Maps van types vragen bij en hun corresponderende factories, visitors, ...
 */
public class Maker {
    private final Map<String, TypeFactory> factoryMap;
    private final Map<String, CardVisitor> cardVisitorMap;
    public Maker(){
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
    public TypeFactory makeFactory(String symbol){
        return factoryMap.get(symbol);
    }
    public CardVisitor makeVisitor(String symbol){
        return cardVisitorMap.get(symbol);
    }
}