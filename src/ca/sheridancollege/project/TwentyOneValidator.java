/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author Amanda
 */

// checks to see if a player/dealer has a hand totaling 21
// user after the first 2 dealt cards and and everytime thereafter
public class TwentyOneValidator {
    
    public final int win = 21;
    public final int multiplier = 1.5;
    
    for (Card card: hand) {
        total += card;
        if (total == win){
            Player.balance = balance * multiplier;
        } else {
            // call to stand or hit
        }
    }
    
}
