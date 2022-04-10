package be.ugent.flash.cards;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.*;

/**
 * Model voor {@link Type}
 */

public class CardModel implements Observable {

    private final List<InvalidationListener> listenerList;
    private LinkedList<Type> types;

    public CardModel(){
        this.listenerList = new ArrayList<>();
    }

    public void setCardsList(LinkedList<Type> types){
        this.types = types;
    }

    public LinkedList<Type> getAllCards(){
        return types;
    }

    public void addAsLast(Type card){
        types.remove(card);
        removeListener(card);
        card.clear();
        types.offerLast(card);
        addListener(card);
        if(types.size() > 1){
            card.getNextCard().setPopUpLabelVisible(true);
            card.showNextCard();
            fireInvalidationListener();
        } else {
            card.setNextCard(card);
            card.setPopUpLabelVisible(true);
            card.showNextCard();
        }
    }

    public void removeCard(Type listener){
        if(types.size() < 2){
            listener.setNextCard(null);
        }
        listener.clear();
        listener.showNextCard();
        types.remove(listener);
        removeListener(listener);
        fireInvalidationListener();
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {
        listenerList.add(invalidationListener);
    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        listenerList.remove(invalidationListener);
    }

    public void fireInvalidationListener(){
        listenerList.forEach(listener -> listener.invalidated(this));
    }

    public void change(int index){
        if(types.size() >= 2){
            if ((index == types.size() - 1)) {
                types.get(index).setNextCard(types.get(0));
            } else {
                types.get(index).setNextCard(types.get(index + 1));
            }
        } else {
            types.get(0).setNextCard(null);
        }
    }
}