/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edit3;

import New_Edit.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author dhruv
 */
public class CardDistributor {

    private ArrayList<Card> uCards = new ArrayList<>();
    private ArrayList<Card> dCards = new ArrayList<>();
    private ArrayList<Card> Deck = new ArrayList<>();
    private int count = 0;
    private int remaining = 52;

    public CardDistributor() {
    }

    public void setDeck(ArrayList<Card> Deck) {
        this.Deck = Deck;
    }

    public ArrayList<Card> getCard() {
        Iterator<Card> it = Deck.iterator();
        uCards.add(it.next());
        it.remove();
        count++;
        remaining--;
        return uCards;
    }

    public ArrayList<Card> dealerCards() {
        Iterator<Card> it = Deck.iterator();
        dCards.add(it.next());
        it.remove();
        count++;
        remaining--;
        return dCards;
    }

    public ArrayList<Card> getDeck() {
        return Deck;
    }

    public void print() {
        for (Card card : Deck) {
            System.out.println(card.getValue() + " of " + card.getSuit() + "\t");
        }
    }

}
