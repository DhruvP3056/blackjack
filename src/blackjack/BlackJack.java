package blackjack;

/**
 * @author Amanda Jose, 2021
 * @author Vigneshwar Premachandran, 2021
 * @author Dhruv Patel, 2021
 * @author Zain Qureshi, 2021
 * Project: Deliverable 3
 * 2021-04-18
 */
import blackjack.view.GameManagerUI;
import blackjack.model.StandardPlayer;
import blackjack.model.Deck;
import blackjack.view.BlackjackUI;
import java.util.ArrayList;

public class BlackJack {

    public static ArrayList<StandardPlayer> players = new ArrayList();

    public static void main(String[] args) {

        BlackjackUI blackjackView = new BlackjackUI();

        //------------GameManager Controller Code---------------
        
        boolean stillJoining = true;
        GameManagerUI gm = new GameManagerUI();

        //Tutorial
        gm.tutorial();
        
        //Game Menu
        do {
            
            String command = gm.mainMenu(players);
            if (command.equalsIgnoreCase("")) {

                players.add(gm.getPlayerRegistration());

            } else if (command.equalsIgnoreCase("Q")) {

                gm.quitGame(players);

            } else if (gm.doesPlayerExist(players, command)) {

                players.remove(gm.getPlayerObject(players, command));

            } else if (command.equalsIgnoreCase("start")) {
                stillJoining = false;
            }
            
            if(players.size() >= 4){
                stillJoining = false;
            }
        } while (stillJoining == true);

        gm.showAllPlayerBalance(players);

        //Creating Main Deck
        Deck playingDeck = new Deck();
        //Adding 52 ordered cards to the deck
        playingDeck.createDeck();
        //shuffling the Deck
        playingDeck.shuffle();

        //Main Game Loop
        do {
            //checking if players have a balance of $0
            blackjackView.removePlayer(players);
            //allowing players to bet
            gm.placingBets(players);

            //dealercards will be created first
            Deck dealerCards = new Deck();
            //Giving two cards to dealer
            dealerCards.draw(playingDeck);
            dealerCards.draw(playingDeck);

            //ArrayList to hold the hands of the players
            ArrayList<Deck> playersDeck = new ArrayList();

            blackjackView.startGame(players, playingDeck, dealerCards, playersDeck);

            blackjackView.showDealersCards(dealerCards);

            blackjackView.DealersTurnToHit(dealerCards, playingDeck);

            blackjackView.showDealersHandValue(dealerCards);

            blackjackView.isDealerBusted();

            blackjackView.tieChecker(dealerCards, playersDeck, players);

            blackjackView.winChecker(dealerCards, playersDeck, players);

            blackjackView.moneyUpdate(players);

        } while (blackjackView.newRound(playingDeck));

    }
}
