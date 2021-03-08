/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dhruv
 */
public class points extends Game {

    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> uCards = new ArrayList<>();
    private ArrayList<Card> dCards = new ArrayList<>();
    private int count = 0;
    private int remaining = 52;
    private int userPoints = 0;
    private int dealerPoints = 0;

    Hand t = new Hand();
    Scanner in = new Scanner(System.in);

    public points(String name) {
        super(name);
        UpdateData(t.getCards(), t.getuCards(), t.getdCards(), count, remaining);
        super.UpdateData(cards, uCards, dCards, count, remaining);
        printUserCards();
    }

    @Override
    public void UpdateData(ArrayList cards, ArrayList uCards, ArrayList dCards, int count, int remaining) {
        this.cards = cards;
        this.uCards = uCards;
        this.dCards = dCards;
        this.count = count;
        this.remaining = remaining;
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
        System.out.println(userPoints);

    }

    public void dealerPoint() {
        dCards.trimToSize();
        for (int i = 0; i < dCards.size(); i++) {
            Card x = dCards.get(i);
            switch (x.getValue()) {
                case ACE:
                    System.out.println("Would you like to make it 1 or 11?");
                    int ch = in.nextInt();
                    if (ch == 1) {
                        dealerPoints += 1;
                        break;
                    }
                    if (ch == 11) {
                        dealerPoints += 11;
                        break;
                    }
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
        System.out.println(dealerPoints);

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
        System.out.println(userPoints);

    }

    public void dealerPointUpdate() {
        dCards.trimToSize();
        for (int i = dCards.size() - 1; i < dCards.size(); i++) {
            Card x = dCards.get(i);
            switch (x.getValue()) {
                case ACE:
                    System.out.println("Would you like to make it 1 or 11?");
                    int ch = in.nextInt();
                    if (ch == 1) {
                        dealerPoints += 1;
                        break;
                    }
                    if (ch == 11) {
                        dealerPoints += 11;
                        break;
                    }
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
        System.out.println(dealerPoints);

    }

    public void printUserCards() {
        System.out.println("User Cards Are \n");
        uCards.forEach(x -> {
            System.out.println(x.getValue() + " " + x.getSuit());
        });
    }

    public void printDealerCards() {
        System.out.println("Dealer Cards Are");

        dCards.forEach(x -> {
            System.out.println(x.getValue() + " " + x.getSuit());
        });
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

    public int getCount() {
        return count;
    }

    public int getRemaining() {
        return remaining;
    }

    @Override
    public void declareWinner() {

    }

    @Override
    public void play() {

    }
}
