/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Dhruv_Edit;

/**
 *
 * @author dhruvpatel
 * @author Vigneshwar Premachandran
 *
 */
public class StandardPlayer {

    private double currentBet;
    private String name; //the unique name for this player
    private double wallet = 500;
    private boolean endRound = false;
    private boolean naturalWin = false;

    public StandardPlayer() {

    }

    public StandardPlayer(String dealer, double houseBalance) {
        this.name = dealer;
        this.wallet = houseBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
    
    public void setEndRound(boolean endRound) {
        this.endRound = endRound;
    }

    public boolean isNaturalWin() {
        return naturalWin;
    }

    public void setNaturalWin(boolean naturalWin) {
        this.naturalWin = naturalWin;
    }
    
    public boolean isEndRound() {
        return endRound;
    }



    //For creating a dealer player and specifying the balance of the house
    public double getCurrentBet() {
        return currentBet;
    }

    public String getName() {
        return name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setCurrentBet(double currentBet) {
        do {
            if (currentBet <= getWallet() && currentBet > 0) {
                this.currentBet = currentBet;
                break;
            } else {
                throw new IllegalArgumentException("Please enter a valid bet amount!");
            }
        } while (this.currentBet <= 0);

    }

    @Override
    public String toString() {
        return this.getName();
    }

}
