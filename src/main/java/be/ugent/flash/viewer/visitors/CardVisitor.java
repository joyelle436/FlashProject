package be.ugent.flash.viewer.visitors;

import be.ugent.flash.viewer.cards.Type;

/**
 * wordt geimplementeerd door elke klasse die een {@link Type} tekent(de nodige componeneten toevoegd aan de Borderpane)
 * @param <T>
 */
public interface CardVisitor<T extends Type> {
    void buildCard(T type);
    void visit(T type);
}
