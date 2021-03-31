/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Dhruv Patel March 2021
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> p1Cards = new ArrayList<>();
    private ArrayList<Card> p2Cards = new ArrayList<>();
    private ArrayList<Card> p3Cards = new ArrayList<>();
    private ArrayList<Card> p4Cards = new ArrayList<>();
    private ArrayList<Card> dCards = new ArrayList<>();
    private int count = 0;
    private int remaining = 52;

    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;

    }

    public GroupOfCards() {
        cards.clear();
        this.shuffle();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void UpdateData(ArrayList cards, ArrayList dCards, ArrayList p1Cards, ArrayList p2Cards, ArrayList p3Cards, ArrayList p4Cards, int count, int remaining) {
        this.cards = cards;
        this.dCards = dCards;
        this.p1Cards = p1Cards;
        this.p2Cards = p2Cards;
        this.p3Cards = p3Cards;
        this.p4Cards = p4Cards;    
        this.count = count;
        this.remaining = remaining;
    }

    public void shuffle() {
        Deck main = new Deck();
        cards = main.getCards();
        Collections.shuffle(cards);
    }

    public ArrayList<Card> getuCards() {
        return p1Cards;
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

    public void print() {
        System.out.println("Hello From Group Class");
        cards.forEach(x -> {
            System.out.println(x.getValue() + " " + x.getSuit());
        });
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}//end class