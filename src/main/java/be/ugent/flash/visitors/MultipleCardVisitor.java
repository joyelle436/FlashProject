package be.ugent.flash.visitors;

import be.ugent.flash.questions.MultipleCard;

public class MultipleCardVisitor implements CardVisitor<MultipleCard>{

    public static void buildCard(MultipleCard multipleCard){
        multipleCard.accept(new MultipleCardVisitor());
    }
    @Override
    public void visit(MultipleCard multipleCard) {
    }
}
