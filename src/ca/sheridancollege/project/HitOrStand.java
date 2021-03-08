/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author dhruv
 */
public class HitOrStand extends Game {

    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> uCards = new ArrayList<>();
    private ArrayList<Card> dCards = new ArrayList<>();
    private int count = 0;
    private int remaining = 52;

    points t = new points("Hello");
    Scanner in = new Scanner(System.in);

    public HitOrStand(String string) {
        super(string);
        UpdateData(t.getCards(), t.getuCards(), t.getdCards(), t.getCount(), t.getRemaining());
        super.UpdateData(cards, uCards, dCards, count, remaining);
        t.userPoint();
        t.dealerPoint();
        UserChoice();
        super.UpdateData(cards, uCards, dCards, count, remaining);
        t.UpdateData(cards, uCards, dCards, count, remaining);
        t.userPointUpdate();
        t.dealerPointUpdate();
    }

    @Override
    public void UpdateData(ArrayList cards, ArrayList uCards, ArrayList dCards, int count, int remaining) {
        this.cards = cards;
        this.uCards = uCards;
        this.dCards = dCards;
        this.count = count;
        this.remaining = remaining;

    }

    public void UserChoice() {
        System.out.println("Hit or Stand?");
        String choice = in.nextLine();
        if (choice.equalsIgnoreCase("hit")) {
            HitUser();
            printUserCards();
        } else {
            System.out.println("Dealers Turn.");
        }
    }

    public void HitUser() {
        Iterator<Card> it = cards.iterator();
        uCards.add(it.next());
        it.remove();
        count++;
        remaining--;
    }

    public void HitDealer() {
        Iterator<Card> it = cards.iterator();
        dCards.add(it.next());
        it.remove();
        count++;
        remaining--;
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

    public void print() {
        System.out.println("Hello From Hit CLass");
        cards.forEach(x -> {
            System.out.println(x.getValue() + " " + x.getSuit());
        });
//        t.printParent();
//        t.print();
    }

    @Override
    public void declareWinner() {

    }

    @Override
    public void play() {
        printUserCards();
        UserChoice();

    }
}
