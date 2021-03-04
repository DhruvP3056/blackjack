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
 */
public class Hand extends GroupOfCards {

    ArrayList<Card> hands = new ArrayList<>();
    ArrayList<Card> Deck = new ArrayList<>();
    private int count = 0;
    private int remaining = 52;
    private boolean user = true;

    public Hand() {
        Deck = super.getCards();
        generateHand();
    }

    public void generateHand() {
    Deck.forEach(x -> {
            System.out.println(x.getValue() + " " + x.getSuit());
        });
    while(count < 4){
            for (int i = 0;i<4;i++) {
                Iterator<Card> it = Deck.iterator();
                hands.add(it.next());
                it.remove();
                count++;
                remaining--;
            }
    }
        
    }

    @Override
    public void print() {
        System.out.println();
        System.out.println();
        hands.forEach(x -> {
            System.out.println(x.getValue() + " " + x.getSuit());
        });
        System.out.println();
//        Deck.forEach(x -> {
//            System.out.println(x.getValue() + " " + x.getSuit());
//        });
        System.out.println(hands.size() + " " + Deck.size() + " " + remaining);

    }
}
