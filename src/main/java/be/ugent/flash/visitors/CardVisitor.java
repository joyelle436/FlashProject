package be.ugent.flash.visitors;

import be.ugent.flash.questions.Type;

public interface CardVisitor<T extends Type> {
    void visit(T type);
}
