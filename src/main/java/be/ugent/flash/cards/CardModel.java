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

    public void addAsLast(InvalidationListener listener){
        Type type = (Type) listener;
        types.remove((Type) listener);
        removeListener(listener);
        type.clear();
        types.offerLast(type);
        addListener((InvalidationListener) type);
        if(types.size() > 1){
            type.showNextCard();
            fireInvalidationListener();
        } else {
            type.clear();
            type.setNextCard(type);
            type.showNextCard();
        }
    }

    public void removeCard(InvalidationListener listener){
        Type type = (Type) listener;
        if(types.size() <= 1){
            type.setNextCard(null);
        }
        type.showNextCard();
        types.remove((Type) listener);
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
            if(index == types.size()-1){
                types.get(index).setNextCard(types.get(0));
            } else {
                types.get(index).setNextCard(types.get(index+1));
            }
        } else {
            types.get(0).setNextCard(null);
        }
    }
}