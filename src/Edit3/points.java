/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edit3;

import New_Edit.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dhruv
 */
public class points {

    private ArrayList<Card> uCards = new ArrayList<>();
    private ArrayList<Card> dCards = new ArrayList<>();
    private int userPoints = 0;
    private int dealerPoints = 0;

    Scanner in = new Scanner(System.in);

    public points() {
    }

    public void userPoint() {
        uCards.trimToSize();
        for (int i = 0; i < uCards.size(); i++) {
            Card x = uCards.get(i);
            switch (x.getValue()) {
                case ACE:
                    System.out.println("Would you like to make it 1 or 11?");
                    int ch = in.nextInt();
                    if (ch == 1) {
                        userPoints += 1;
                        break;
                    }
                    if (ch == 11) {
                        userPoints += 11;
                        break;
                    }
                case TWO:
                    userPoints += 2;
                    break;

                case THREE:
                    userPoints += 3;
                    break;

                case FOUR:
                    userPoints += 4;
                    break;

                case FIVE:
                    userPoints += 5;
                    break;

                case SIX:
                    userPoints += 6;
                    break;

                case SEVEN:
                    userPoints += 7;
                    break;

                case EIGHT:
                    userPoints += 8;
                    break;

                case NINE:
                    userPoints += 9;
                    break;

                case JACK:
                    userPoints += 10;
                    break;

                case QUEEN:
                    userPoints += 10;
                    break;

                case KING:
                    userPoints += 10;
                    break;

            }
        }

    }

    public void dealerPoint() {
        dCards.trimToSize();
        for (int i = 0; i < dCards.size(); i++) {
            Card x = dCards.get(i);
            switch (x.getValue()) {
                case ACE:

                    dealerPoints += 11;
                    break;

                case TWO:
                    dealerPoints += 2;
                    break;

                case THREE:
                    dealerPoints += 3;
                    break;

                case FOUR:
                    dealerPoints += 4;
                    break;

                case FIVE:
                    dealerPoints += 5;
                    break;

                case SIX:
                    dealerPoints += 6;
                    break;

                case SEVEN:
                    dealerPoints += 7;
                    break;

                case EIGHT:
                    dealerPoints += 8;
                    break;

                case NINE:
                    dealerPoints += 9;
                    break;

                case JACK:
                    dealerPoints += 10;
                    break;

                case QUEEN:
                    dealerPoints += 10;
                    break;

                case KING:
                    dealerPoints += 10;
                    break;

            }
            if (dealerPoints > 21) {
                dealerPoints -= 10;
            }
        }

    }

    public void userPointUpdate() {
        uCards.trimToSize();
        for (int i = uCards.size() - 1; i < uCards.size(); i++) {
            Card x = uCards.get(i);
            switch (x.getValue()) {
                case ACE:
                    System.out.println("Would you like to make it 1 or 11?");
                    int ch = in.nextInt();
                    if (ch == 1) {
                        userPoints += 1;
                        break;
                    }
                    if (ch == 11) {
                        userPoints += 11;
                        break;
                    }
                case TWO:
                    userPoints += 2;
                    break;

                case THREE:
                    userPoints += 3;
                    break;

                case FOUR:
                    userPoints += 4;
                    break;

                case FIVE:
                    userPoints += 5;
                    break;

                case SIX:
                    userPoints += 6;
                    break;

                case SEVEN:
                    userPoints += 7;
                    break;

                case EIGHT:
                    userPoints += 8;
                    break;

                case NINE:
                    userPoints += 9;
                    break;

                case JACK:
                    userPoints += 10;
                    break;

                case QUEEN:
                    userPoints += 10;
                    break;

                case KING:
                    userPoints += 10;
                    break;

            }
        }

    }

    public void dealerPointUpdate() {
        dCards.trimToSize();
        for (int i = dCards.size() - 1; i < dCards.size(); i++) {
            Card x = dCards.get(i);
            switch (x.getValue()) {
                case ACE:

                    dealerPoints += 1;
                    break;

                case TWO:
                    dealerPoints += 2;
                    break;

                case THREE:
                    dealerPoints += 3;
                    break;

                case FOUR:
                    dealerPoints += 4;
                    break;

                case FIVE:
                    dealerPoints += 5;
                    break;

                case SIX:
                    dealerPoints += 6;
                    break;

                case SEVEN:
                    dealerPoints += 7;
                    break;

                case EIGHT:
                    dealerPoints += 8;
                    break;

                case NINE:
                    dealerPoints += 9;
                    break;

                case JACK:
                    dealerPoints += 10;
                    break;

                case QUEEN:
                    dealerPoints += 10;
                    break;

                case KING:
                    dealerPoints += 10;
                    break;

            }
        }

    }

    public ArrayList<Card> getuCards() {
        return uCards;
    }

    public int getUserPoints() {
        return userPoints;
    }

    public int getDealerPoints() {
        return dealerPoints;
    }

    public ArrayList<Card> getdCards() {
        return dCards;
    }

    public void setuCards(ArrayList<Card> uCards) {
        this.uCards = uCards;
    }

    public void setdCards(ArrayList<Card> dCards) {
        this.dCards = dCards;
    }

    public void calculatePoints(StandardPlayer player, ArrayList<Card> uCards, ArrayList<Card> dCards) {
        setuCards(uCards);
        setdCards(dCards);
        userPoint();
        dealerPoint();
    }
}
