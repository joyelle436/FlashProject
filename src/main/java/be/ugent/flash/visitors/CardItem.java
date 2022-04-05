package be.ugent.flash.visitors;

import be.ugent.flash.cards.Type;

public interface CardItem<T extends Type> {
    void accept(CardVisitor<T> cardVisitor);
}
