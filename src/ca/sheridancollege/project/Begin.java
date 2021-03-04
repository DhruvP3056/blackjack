/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author dhruv
 */
public class Begin extends Game {
    
    public Begin(String string) {
        super(string);
    }

    @Override
    public void play(){
        GroupOfCards first = new GroupOfCards();
            first.print();
    }
    @Override
    public void declareWinner(){
        
    }
}
