 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author dhruv
 */
public final class Deck extends Card {
    private ArrayList<Card> cards = new ArrayList<>();
    //creating a unshuffeled deck of 52 cards
    public Deck(){
        Create();
    }
    public void Create(){
        int fill = 0;
        for(int suit = 0;suit<Card.Suit.values().length;suit++){
            for(int value = 1;value<Card.Value.values().length;value++){
                Deck x = new Deck(Card.Value.values()[value],Card.Suit.values()[suit]);
                cards.add(fill, x);
                fill++;
            }
        }
    }
    public Deck(Value value, Suit suit){
        super(value,suit);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void print(){
//        System.out.println(cards.size());
        cards.forEach(x -> {
            System.out.println( x.getValue() + " of "+ x.getSuit() );
        });
    }
    @Override
    public String toString(){
       return ""+cards;
    }
}