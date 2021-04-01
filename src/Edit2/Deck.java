/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edit2;

import Edit2.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author dhruv
 */
public final class Deck extends Card {

    private ArrayList<Card> cards = new ArrayList<>();

    //creating a unshuffeled deck of 52 cards
    public Deck() {
        Create();
        Collections.shuffle(cards);
    }

    public void Create() {
        int fill = 0;
        for (int suit = 0; suit < Card.Suit.values().length; suit++) {
            for (int value = 1; value < Card.Value.values().length; value++) {
                Deck x = new Deck(Card.Value.values()[value], Card.Suit.values()[suit]);
                cards.add(fill, x);
                fill++;
            }
        }
    }

    public Deck(Value value, Suit suit) {
        super(value, suit);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

//    public void print() {
//        cards.forEach(card -> {
//            System.out.println(card.getValue() + " of " + card.getSuit() + "\t");
//        });
//    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
