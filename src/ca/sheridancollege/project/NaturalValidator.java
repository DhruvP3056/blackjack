/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Value;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */

// checks to see if a player/dealer has natural (a hand totaling 21)
// use after the first 2 dealt cards 
public class NaturalValidator {
    
    public static final int WIN = 21;
    public static int uTotal;
    public static int dTotal;
    
    public static int validateUserHand(ArrayList<Card> uCards){
       
        for(Card card: uCards){
            if (card.getValue() == Value.ACE){
                uTotal += 11;
            }        
            if (card.getValue() == Value.TEN){
                uTotal += 10;
            }
            if (card.getValue() == Value.JACK){
                uTotal += 10;
            }   
            if (card.getValue() == Value.QUEEN){
                uTotal += 10;
            }  
            if (card.getValue() == Value.KING){
                uTotal += 10;
            }
        }
        
        return uTotal;     
    }
    
    public static int validateDealerHand(ArrayList<Card> dCards){
       
        for(Card card: dCards){
            if (card.getValue() == Value.ACE){
                dTotal += 11;
            }        
            if (card.getValue() == Value.TEN){
                dTotal += 10;
            }
            if (card.getValue() == Value.JACK){
                dTotal += 10;
            }   
            if (card.getValue() == Value.QUEEN){
                dTotal += 10;
            }  
            if (card.getValue() == Value.KING){
                dTotal += 10;
            }
        }
        
        return uTotal;
    }  
    
    public static void validateWinner(int uTotal, int dTotal, ArrayList<StandardPlayer> players){
        if (uTotal == dTotal){
            //return call to stand or hit
        }else if(uTotal == WIN){
            BalanceCalculator.calculateBalance(players.get(1)); //** NOTE: need to tie uCards with a player, 1 is a placeholder
        }else if(dTotal == WIN){
            for (StandardPlayer player: players){
                double loss = player.getWallet() - player.getCurrentBet();
                player.setWallet(loss);
                player.setCurrentBet(0);
            }  
        }else{
            //return call to stand or hit
        }
    }
}
