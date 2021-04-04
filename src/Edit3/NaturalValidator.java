/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edit3;

import Edit3.Card.Value;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
// checks to see if a player/dealer has natural (a hand totaling 21)
// use after the first 2 dealt cards 
public class NaturalValidator {

    public final int WIN = 21;
    public int uTotal;
    public int dTotal;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> uCards = new ArrayList<>();
    private ArrayList<Card> dCards = new ArrayList<>();
    String result;

    public NaturalValidator() {
        super();
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Card> getuCards() {
        return uCards;
    }

    public ArrayList<Card> getdCards() {
        return dCards;
    }

    public void validateUserHand(ArrayList<Card> uCards) {

        for (Card card : uCards) {
            if (card.getValue() == Value.ACE) {
                uTotal += 11;
            }
            if (card.getValue() == Value.TEN) {
                uTotal += 10;
            }
            if (card.getValue() == Value.JACK) {
                uTotal += 10;
            }
            if (card.getValue() == Value.QUEEN) {
                uTotal += 10;
            }
            if (card.getValue() == Value.KING) {
                uTotal += 10;
            }
        }

    }

    public void validateDealerHand(ArrayList<Card> dCards) {

        for (Card card : dCards) {
            if (card.getValue() == Value.ACE) {
                dTotal += 11;
            }
            if (card.getValue() == Value.TEN) {
                dTotal += 10;
            }
            if (card.getValue() == Value.JACK) {
                dTotal += 10;
            }
            if (card.getValue() == Value.QUEEN) {
                dTotal += 10;
            }
            if (card.getValue() == Value.KING) {
                dTotal += 10;
            }
        }
    }

    public void validate(StandardPlayer player, ArrayList<Card> uCards, ArrayList<Card> dCards) {
        validateDealerHand(dCards);
        validateUserHand(uCards);
        if (uTotal == WIN) {
            System.out.println(player.getName() + "You Got A Natural Win!!");
            result="uWin";
        } else if (dTotal == WIN) {
            result="dWin";
            System.out.println("Dealer Got A Natural Win");
            System.out.println("Next Round");
        }
    }

    public void validateNaturalWinner(StandardPlayer player, ArrayList<Card> uCards, ArrayList<Card> dCards, ArrayList<Card> deck, int size, int count3) {

        if (result.equalsIgnoreCase("done")) {

            HitOrStand hitOrStand = new HitOrStand(player, uCards, dCards, deck);
            hitOrStand.play(player);
            this.cards = hitOrStand.getCards();
            this.uCards = hitOrStand.getuCards();
            this.dCards = hitOrStand.getdCards();

            if (count3 == size - 1) {
                System.out.println();
                System.out.println("Dealers Turn");
                hitOrStand.DealersTurn();
            }

        }
    }

}
