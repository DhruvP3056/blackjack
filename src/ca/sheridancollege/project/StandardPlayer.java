package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Vigneshwar Premachandran
 */
public class StandardPlayer extends Player{

    private double currentBet;
    
    public StandardPlayer(){  
    }
    
    public StandardPlayer(String name) {
        super(name);
    }

    //For creating a dealer player and specifying the balance of the house
    public StandardPlayer(String name, double amount){
        super(name,amount);
    }

    public double getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(double currentBet) {
        do{
            if(currentBet <= super.getWallet() && currentBet > 0){
                this.currentBet = currentBet;
                break;
            }
            else{
                throw new IllegalArgumentException("Please enter a valid bet amount!");
            }
        }while(this.currentBet <= 0);
        
    }
    
 
     //This method checks the Array of players and returns the player object corresponding to the passed name.
    public StandardPlayer getPlayerObject(ArrayList<StandardPlayer> players, String nameToCheck){
        StandardPlayer temp = new StandardPlayer();
        for(StandardPlayer player:players){
            if(player.getName().equalsIgnoreCase(nameToCheck)){
                temp = player;
            }
        }
        return temp;
    }
    
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        return this.getName();
    }
    
}
