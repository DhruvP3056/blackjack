/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.model;

import java.util.ArrayList;

/**
 * NOTE: NOT IMPLEMENTED, BUT WOULD LIKE TO ***
 * 
 * @author Amanda Jose, 2021
 * @author Vigneshwar Premachandran
 */
public class HandValueCalculator {
    
    private static HandValueCalculator instance = null;
    
    private HandValueCalculator(){     
    }
    
    public static HandValueCalculator getInstance(){
        if(instance == null){
            instance = new HandValueCalculator();
        }
        return instance;
    }
    //Calculate the value of the hand
    public int cardsValue(ArrayList<Card> cards) {
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
}
