package ca.sheridancollege.project;

/**
 *
 * @author vigneshwar premachandran
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
    

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        return this.getName();
    }
    
}
