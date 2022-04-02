package be.ugent.flash.visitors;

import be.ugent.flash.questions.CompactCard;
import be.ugent.flash.questions.Type;

public interface CardVisitor<T extends Type> {
    void buildCard(T type);
    void visit(T type);
}
