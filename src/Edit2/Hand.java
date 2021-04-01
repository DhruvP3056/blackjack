/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edit2;

import Edit2.*;
import java.util.ArrayList;

/**
 *
 * @author dhruv
 * @author Zain Qureshi
 */
public class Hand extends CardDistributor {

    private ArrayList<Card> uCards = new ArrayList<>();
    private ArrayList<Card> dCards = new ArrayList<>();

    public Hand(ArrayList<Card> Deck) {
        super.setDeck(Deck);
    }

    public void showUserHand() {
        uCards.forEach(card -> {
            System.out.println(card.getValue() + " of " + card.getSuit() + "\t");
        });
    }

    public void showDealerHand() {
        dCards.forEach(card -> {
            System.out.println(card.getValue() + " of " + card.getSuit() + "\t");
        });
    }

    public void addUserCard() {
        this.uCards = super.getCard();
    }
    public void addDealerCard() {
        this.dCards = super.getCard();
    }

    public ArrayList<Card> getuCards() {
        return uCards;
    }

    public ArrayList<Card> getdCards() {
        return dCards;
    }
    public ArrayList<Card> getUpdatedDeck() {
        return super.getDeck();
    }

    public ArrayList<Card> getOriginalDeck() {
        return super.getDeck();
    }

    public void setUpdatedDeck(ArrayList<Card> dd) {
        super.setDeck(dd);
    }

    public void setuCards(ArrayList<Card> uCards) {
        this.uCards = uCards;
    }

    public void setdCards(ArrayList<Card> dCards) {
        this.dCards = dCards;
    }
    
    public void pl(){
        super.print();
    }

}
