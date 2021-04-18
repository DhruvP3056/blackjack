
package blackjack.model;

import java.util.ArrayList;
import java.util.Collections;

/*
This class is a model for creating decks
It can hold any amount of cards
It can be used as the main deck or the players hand
It is adaptable to the programmers liking
 */
/**
 * @author Amanda Jose, 2021
 * @author Vigneshwar Premachandran, 2021
 * @author Dhruv Patel, 2021
 * @author Zain Qureshi, 2021
 * Project: Deliverable 3
 * 2021-04-18
 */
public class Deck {
    
    private ArrayList<Card> cards;

    public Deck() {
        //initiliazing the deck
        this.cards = new ArrayList<Card>();
    }

    //making a deck of 52 cards
    public void createDeck() {
        //Generating using for loop
        //Looping through Suits and Value enum to make a full deck ordered
        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()) {
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    
    //Shuffeling the Deck
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    //Removing a card from a deck
    public void removecard(int i) {
        this.cards.remove(i);
    }

    //Get Card from deck
    public Card getCard(int i) {
        return this.cards.get(i);
    }

    //add card to deck
    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    //Drawing from the deck given in the param
    public void draw(Deck mainDeck) {
        //add card to current deck from the given deck
        this.cards.add(mainDeck.getCard(0));
        //remove the card after adding
        mainDeck.removecard(0);
    }

    public int deckSize() {
        return this.cards.size();
    } 
    
    @Override
    public String toString(){
        return cards.toString();
    }
}
