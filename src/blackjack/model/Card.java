/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

import blackjack.model.Value;
import blackjack.model.Suit;

/**
 *
 * @author dhruvpatel
 * @author Amanda Jose, 2021
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
