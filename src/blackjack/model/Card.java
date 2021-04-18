
package blackjack.model;

/**
 * @author Amanda Jose, 2021
 * @author Vigneshwar Premachandran, 2021
 * @author Dhruv Patel, 2021
 * @author Zain Qureshi, 2021
 * Project: Deliverable 3
 * 2021-04-18
 */
public class Card {
    private Suit suit;
    private Value value;
    
    public Card(Suit suit,Value value){
        this.suit=suit;
        this.value=value;
    }
    
    public Value getValue(){
        return this.value;
    }

    public Suit getSuit(){
        return this.suit;
    }  

    @Override
    public String toString(){
        return this.value.toString() + " of " + this.suit.toString();
    }    
}
