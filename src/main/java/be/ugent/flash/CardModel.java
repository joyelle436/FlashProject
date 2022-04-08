package be.ugent.flash;

import be.ugent.flash.cards.Type;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.*;

/**
 * Model voor {@link Type}
 */

public class CardModel implements Observable {

    private List<InvalidationListener> listenerList;
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
        fireInvalidationListener();
    }

    public void removeCard(InvalidationListener listener){
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
}
