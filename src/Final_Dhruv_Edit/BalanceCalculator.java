/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Dhruv_Edit;

/**
 *
 * @author dhruvpatel
 */
public class BalanceCalculator {

    public final double MULTIPLIER = 1.5;
    public double winnings;

    public double calculateBalance(StandardPlayer player) {
        winnings += player.getCurrentBet() * MULTIPLIER;
        return winnings;
    }
}
