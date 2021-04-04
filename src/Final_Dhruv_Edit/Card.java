/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Dhruv_Edit;

/**
 *
 * @author dhruvpatel
 */
public class Card {
    private Suit suit;
    private Value value;
    
    public Card(Suit suit,Value value){
        this.suit=suit;
        this.value=value;
    }
    public String toString(){
        return this.value.toString() + " of " + this.suit.toString();
    }
    
    public Value getValue(){
        return this.value;
    }
}
