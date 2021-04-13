/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

import blackjack.model.Card;
import blackjack.model.Value;
import blackjack.model.Suit;
import java.util.ArrayList;
import java.util.Collections;

/*
This class is a model for creating decks
It can hold any amount of cards
It can be used as the main deck or the players hand
It is adaptable to the programmers liking
 */
/**
 *
 * @author dhruvpatel
 * @author Amanda Jose, 2021
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

    public int cardsValue() {
        int totalValue = 0;
        int aces = 0;
        //For each card in the deck
        for (Card card : cards) {
            switch (card.getValue()) {
                case ACE:
                    aces += 1;
                    break;
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                    totalValue += 10;
                    break;
                case JACK:
                    totalValue += 10;
                    break;
                case QUEEN:
                    totalValue += 10;
                    break;
                case KING:
                    totalValue += 10;
                    break;
            }
            
        }
        
        //Now checking how many aces are there and adding points accordingly
        //aces are worth 1 or 11
        //If there is ace but hand value is above 10 then 11 points will be added 
        //if the hand value is greater than 10, then 1 will be added
        for(int i=0;i < aces;i++){
            if(totalValue > 10){
                totalValue += 1;
            }else {
                totalValue += 11;
            }
        }
        
        return totalValue;
    }    
    
    @Override
    public String toString(){
        return cards.toString();
    }
}
