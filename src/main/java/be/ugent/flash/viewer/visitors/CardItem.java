package be.ugent.flash.viewer.visitors;

import be.ugent.flash.viewer.cards.Type;

/**
 * Wordt geimplementeerd door elke subklasse van {@link Type} om een visitor te accepteren
 * @param <T>
 */
public interface CardItem<T extends Type> {
    void accept(CardVisitor<T> cardVisitor);
}
