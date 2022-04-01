package be.ugent.flash.visitors;

import be.ugent.flash.questions.StandardCard;

public class StandardCardVisitor implements CardVisitor<StandardCard>{

    public static void buildCard(StandardCard standardCard){
        standardCard.accept(new StandardCardVisitor());
    }
    @Override
    public void visit(StandardCard type) {
    }
}
