package be.ugent.flash.visitors;

import be.ugent.flash.cards.Type;

/**
 * Wordt geimplementeerd door elke subklasse van {@link Type} om een visitor te accepteren
 * @param <T>
 */
public interface CardItem<T extends Type> {
    void accept(CardVisitor<T> cardVisitor);
}
