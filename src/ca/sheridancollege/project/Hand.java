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

    private ArrayList<Card> p1Cards = new ArrayList<>();
    private ArrayList<Card> p2Cards = new ArrayList<>();
    private ArrayList<Card> p3Cards = new ArrayList<>();
    private ArrayList<Card> p4Cards = new ArrayList<>();
    private ArrayList<Card> dCards = new ArrayList<>();
    private ArrayList<Card> Deck = new ArrayList<>();
    private int count = 0;
    private int remaining = 52;
    private boolean user = true;

    public Hand() {
        super();
        Deck = super.getCards();  
        super.UpdateData(Deck, dCards, p1Cards, p2Cards, p3Cards, p4Cards, count, remaining);
    }
    
    public void generateDealerHand (String dealer) {
        Iterator<Card> it = Deck.iterator();
        while (count < 2) {
                if (count == 0 || count == 1) {
                    dCards.add(it.next());
                    it.remove();
                    count++;
                    remaining--;
                }
                }
            }

    public void generatePlayer1Hand(String player1) {
         Iterator<Card> it = Deck.iterator(); 
         while (count >= 2 && count < 4) {
                if (count == 2 || count == 3) {
                    p1Cards.add(it.next());
                    it.remove();
                    count++;
                    remaining--;
                }
                }
    }
    
    public void generatePlayer2Hand(String player2) {
        Iterator<Card> it = Deck.iterator(); 
        while (count >= 4 && count < 6) {
                if (count == 4 || count == 5) {
                    p2Cards.add(it.next());
                    it.remove();
                    count++;
                    remaining--;
                }
                }
    }
    
    public void generatePlayer3Hand (String player3) {
        Iterator<Card> it = Deck.iterator();
        while (count >= 6 && count < 8) {
                if (count == 6 || count == 7) {
                    p3Cards.add(it.next());
                    it.remove();
                    count++;
                    remaining--;
                }
            }
        }
    
    public void generatePlayer4Hand (String player4) {
        Iterator<Card> it = Deck.iterator();
        while (count >= 8 && count < 10) {
                if (count == 8 || count == 9) {
                    p4Cards.add(it.next());
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
        this.p1Cards = uCards;
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

    public void Remaining() {
        System.out.println("Remaining Cards: " + remaining);
    }

    public void printPlayer1Cards() {
        for (Card x : p1Cards) {
            System.out.print(x.getValue() + " of " + x.getSuit() + "\t");
        }
        
        System.out.println();
    }
    
    public void printPlayer2Cards() {
        for (Card x : p2Cards) {
            System.out.print(x.getValue() + " of " + x.getSuit() + "\t");
        }
        
        System.out.println();
    }
    
    public void printPlayer3Cards() {
        for (Card x : p3Cards) {
            System.out.print(x.getValue() + " of " + x.getSuit() + "\t");
        }
        
        System.out.println();
    }
    
    public void printPlayer4Cards() {
        for (Card x : p4Cards) {
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