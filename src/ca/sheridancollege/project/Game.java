/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Game {

    private final String name;//the title of the game
    private ArrayList<Player> players;// the players of the game

    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> uCards = new ArrayList<>();
    private ArrayList<Card> dCards = new ArrayList<>();
    private int count = 0;
    private int remaining = 52;


    public void UpdateData(ArrayList cards, ArrayList uCards, ArrayList dCards, int count, int remaining) {
        this.cards = cards;
        this.uCards = uCards;
        this.dCards = dCards;
        this.count = count;
        this.remaining = remaining;
    }

    public Game(String name) {
        this.name = name;
        players = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public abstract void play();

    public abstract void declareWinner();

}//end class
