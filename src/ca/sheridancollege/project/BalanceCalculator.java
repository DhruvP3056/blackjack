package ca.sheridancollege.project;

/**
 *
 * @author Amanda
 */
public class BalanceCalculator {
    public static final double MULTIPLIER = 1.5;
    public static double winnings;
    
    public static void calculateBalance(StandardPlayer player){
       winnings += player.getCurrentBet() * MULTIPLIER;
       player.setWallet(player.getWallet() + winnings);
    }   
}
