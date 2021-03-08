/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Dhruv Patel March 2021
 */
public abstract class Card {
    //default modifier for child classes
    
    public enum Value{
        Extra,ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING
    }
    public enum Suit{
        SPADES,DIAMONDS,CLUBS,HEARTS
    }
    private Suit suit;
    private Value value;
    public Card(){
        
    }
    public Card(Value value,Suit suit){
        this.suit = suit;
        this.value=value;
    }
    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
    
    
    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public abstract String toString();

}
