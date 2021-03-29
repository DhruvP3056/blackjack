/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author dhruv
 * @author Zain Qureshi
 */
public class Hand extends GroupOfCards {

    private ArrayList<Card> uCards = new ArrayList<>();
    private ArrayList<Card> dCards = new ArrayList<>();
    private ArrayList<Card> Deck = new ArrayList<>();
    private int count = 0;
    private int remaining = 52;
    private boolean user = true;

    public Hand() {
        super();
        Deck = super.getCards();
        generateHand();
        super.UpdateData(Deck, uCards, dCards, count, remaining);
    }

    public void generateHand() {
            for (int i = 0; i < 4; i++) {
                Iterator<Card> it = Deck.iterator();
                if (i == 0 || i == 2) {
                    uCards.add(it.next());
                    it.remove();
                    count++;
                    remaining--;
                }
                if (i == 1 || i == 3) {
                    dCards.add(it.next());
                    it.remove();
                    count++;
                    remaining--;
                }
            }
    }

    public ArrayList<Card> getDeck() {
        return Deck;
    }

    public void setuCards(ArrayList<Card> uCards) {
        this.uCards = uCards;
    }

    public void setdCards(ArrayList<Card> dCards) {
        this.dCards = dCards;
    }

    public void setDeck(ArrayList<Card> Deck) {
        this.Deck = Deck;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public void printUserCards() {
        for (Card x : uCards) {
            System.out.print(x.getValue() + " of " + x.getSuit() + "\t");
        }
        
        System.out.println();
    }

    public void printDealerCards() {
        System.out.print("Dealer: ");
        for (Card x : dCards) {
            System.out.print(x.getValue() + " of " + x.getSuit() + "\t**********");
            break;
        }
        
        System.out.println();
    }

    @Override
    public void print() {
        System.out.println("Hello From Hand CLass");
        Deck.forEach(x -> {
            System.out.println(x.getValue() + " " + x.getSuit());
        });
//        printUserCards();
//        System.out.println();
//        printDealerCards();
//        System.out.println();
//        System.out.println(count + " " + Deck.size() + " " + remaining);

    }
    public void printParent(){
        super.print();
    }
}