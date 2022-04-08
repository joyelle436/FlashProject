package be.ugent.flash.visitors;

import be.ugent.flash.cards.Type;

/**
 * wordt geimplementeerd door elke klasse die een {@link Type} tekent
 * @param <T>
 */
public interface CardVisitor<T extends Type> {
    void buildCard(T type);
    void visit(T type);
}
