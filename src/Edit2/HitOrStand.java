/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edit2;

import Edit2.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dhruv
 */
public class HitOrStand extends points {

    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> uCards = new ArrayList<>();
    private ArrayList<Card> dCards = new ArrayList<>();

    CardDistributor hitOrStand = new CardDistributor();
    Scanner in = new Scanner(System.in);
    String userChoice;

    public HitOrStand(StandardPlayer player, ArrayList<Card> uCards, ArrayList<Card> dCards, ArrayList<Card> cards) {

        super.calculatePoints(player, uCards, dCards);
        hitOrStand.setDeck(cards);
        this.uCards = uCards;
        this.dCards = dCards;

    }

    public void HitUser() {

        this.uCards.addAll(hitOrStand.getCard());
        super.setuCards(uCards);
        super.userPointUpdate();
        this.cards = hitOrStand.getDeck();

    }

    public void HitDealer() {

        this.dCards.addAll(hitOrStand.dealerCards());
        super.setdCards(dCards);
        super.dealerPointUpdate();
        this.cards = hitOrStand.getDeck();

    }

    public void UsersTurn() {

        HitUser();

    }

    public void DealersTurn() {
        System.out.println();
        System.out.println("Dealers Turn to Hit Or Stand.");
        System.out.println();
        System.out.println("Dealers Points " + super.getDealerPoints());
        System.out.println();

        while (super.getDealerPoints() <= 16) {
            HitDealer();

            dCards.forEach(card -> {
                System.out.println(card.getValue() + " of " + card.getSuit() + "\t");
            });

            System.out.println();
        }
        if (super.getDealerPoints() >= 17) {
            System.out.println();
            dCards.forEach(card -> {
                System.out.println(card.getValue() + " of " + card.getSuit() + "\t");
            });
            System.out.println("Dealers Points: " + super.getDealerPoints());
            System.out.println();

            System.out.println("Dealer Stands");

        } else if (super.getDealerPoints() > 21) {
            System.out.println("Dealer Bust's Remaining Players win");
        }
        System.out.println();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public ArrayList<Card> getuCards() {
        return uCards;
    }

    @Override
    public ArrayList<Card> getdCards() {
        return dCards;
    }

    public void play(StandardPlayer player) {

        System.out.println("Dealers Hand Value is: " + super.getDealerPoints());

        System.out.println();

        System.out.println();

        boolean hit = false;

        while (!hit) {

            System.out.println(player.getName() + " Your Hand Value is: " + super.getUserPoints());
            System.out.println();
            System.out.println("Your Cards are:");
            uCards.forEach(card -> {
                System.out.println(card.getValue() + " of " + card.getSuit() + "\t");
            });
            if (super.getUserPoints() > 21) {
                hit = true;
                System.out.println();
                System.out.println("You Busted");
                uCards.forEach(card -> {
                    System.out.println(card.getValue() + " of " + card.getSuit() + "\t");
                });
                System.out.println();
            } else if (super.getUserPoints() == 21) {
                hit = true;
                System.out.println();
                uCards.forEach(card -> {
                    System.out.println(card.getValue() + " of " + card.getSuit() + "\t");
                });
                System.out.println("BlackJack!!!");

            } else if (super.getUserPoints() <= 20) {
                System.out.println(player.getName() + " Would you like to Hit or Stand?");

                userChoice = in.nextLine();
                System.out.println();

                if (userChoice.equalsIgnoreCase("hit")) {

                    UsersTurn();
                    System.out.println();

                } else {

                    hit = true;

                    System.out.println(player.getName() + " You stopped hitting at " + super.getUserPoints());
                    System.out.println();
                    uCards.forEach(card -> {
                        System.out.println(card.getValue() + " of " + card.getSuit() + "\t");
                    });
                    System.out.println();
                    System.out.println("Next Player");

                }
            }
        }

    }

}
