package be.ugent.flash.viewer.cards;

import be.ugent.flash.viewer.ErrorDisplay;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.*;

/**
 * Model voor elke {@link Type} kaart
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
    /**
     * Antwoord werd niet gevonden
     */
    public void addAsLast(Type card){
        types.remove(card);
        removeListener(card);
        card.clear();
        types.offerLast(card);
        addListener(card);
        if(types.size() > 1){
            ErrorDisplay.showErrorLabel(card.getNextCard());
            card.showNextCard();
            fireInvalidationListener();
        } else {
            /*
              Er blijt maar één kaart over
             */
            card.setNextCard(card);
            ErrorDisplay.showErrorLabel(card);
            card.showNextCard();
        }
    }

    /**
     * Antwoord werd gevonden
     */

    public void removeCard(Type card){
        if(types.size() < 2){
            card.setNextCard(null);
        }
        card.clear();
        card.showNextCard();
        types.remove(card);
        removeListener(card);
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

    /**
     * Past de nextCard van {@link Type} aan
     */
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