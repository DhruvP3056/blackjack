/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New_Edit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author dhruv
 */
public class HitOrStand extends points {

    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> uCards = new ArrayList<>();
    private ArrayList<Card> dCards = new ArrayList<>();

    points t = new points();
    Scanner in = new Scanner(System.in);
    String userChoice;

    public HitOrStand(StandardPlayer player, ArrayList<Card> uCards, ArrayList<Card> dCards, ArrayList<Card> cards) {
        super.calculatePoints(player, uCards, dCards);
        this.cards = cards;
        this.dCards = dCards;
        this.uCards = uCards;
    }

    public void HitUser() {

        Iterator<Card> it = cards.iterator();
        uCards.add(it.next());
        it.remove();

    }

    public void HitDealer() {
        Iterator<Card> it = cards.iterator();
        dCards.add(it.next());
        it.remove();
    }

    public void UsersTurn() {

        HitUser();
        super.setuCards(uCards);
        super.userPointUpdate();

    }

    public void DealersTurn() {
        System.out.println();
        System.out.println("Dealers Turn to Hit Or Stand.");
        System.out.println();
        System.out.println("Dealers Points " + super.getDealerPoints());

        while(super.getDealerPoints() <= 16) {
            HitDealer();
            super.setdCards(dCards);
            super.dealerPointUpdate();
        } if (super.getDealerPoints() >= 17) {
            System.out.println();
            System.out.println("Dealers Points: " + super.getDealerPoints());
            System.out.println("Dealer Stands");
        }
        System.out.println();
    }

    public ArrayList<New_Edit.Card> getCards() {
        return cards;
    }

    @Override
    public ArrayList<New_Edit.Card> getuCards() {
        return uCards;
    }

    @Override
    public ArrayList<New_Edit.Card> getdCards() {
        return dCards;
    }

    public void play(StandardPlayer player) {

        System.out.println("Dealers Hand Value is: " + super.getDealerPoints());

        System.out.println();

        System.out.println();

        boolean hit = false;
        while (!hit) {
            System.out.println(player.getName() + " Your Hand Value is: " + super.getUserPoints());
            System.out.println(player.getName() + " Would you like to Hit or Stand?");
            userChoice = in.nextLine();
            if (userChoice.equalsIgnoreCase("hit")) {
                UsersTurn();
            } else {
                hit = true;
                System.out.println(player.getName() + " You stopped hitting at " + super.getUserPoints());
                System.out.println("Next Player");
            }
        }

    }

}
