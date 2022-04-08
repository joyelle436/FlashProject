package be.ugent.flash;

import be.ugent.flash.cards.Type;
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

    public void addAsFirst(InvalidationListener listener){
        types.remove((Type) listener);
        removeListener(listener);
        Type type = (Type) listener;
        type.clear();
        types.offerLast(type);
        addListener((InvalidationListener) type);
        fireInvalidationListener();
    }

    public void removeCard(InvalidationListener listener){
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
        for(InvalidationListener listener: listenerList){
            listener.invalidated(this);
        }
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
