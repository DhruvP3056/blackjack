
package blackjack.model;

/**
 * @author Amanda Jose, 2021
 * @author Vigneshwar Premachandran, 2021
 * @author Dhruv Patel, 2021
 * @author Zain Qureshi, 2021
 * Project: Deliverable 3
 * 2021-04-18
 */
public class StandardPlayer {

    private double currentBet;
    private String name; //the unique name for this player
    private double wallet = 500;
    private boolean endRound = false;
    private boolean naturalWin = false;
    private boolean tie = false;

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

    public boolean isTie() {
        return tie;
    }

    public void setTie(boolean tie) {
        this.tie = tie;
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
