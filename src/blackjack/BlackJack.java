package blackjack;

/**
 *
 * @author dhruvpatel
 * @author Amanda Jose, 2021
 */
import blackjack.view.GameManagerUI;
import blackjack.model.StandardPlayer;
import blackjack.model.Deck;
import blackjack.view.BlackjackUI;
import java.util.ArrayList;

public class BlackJack {

    public static void main(String[] args) {

        ArrayList<StandardPlayer> players = new ArrayList();

        BlackjackUI blackjackView = new BlackjackUI();

        blackjackView.startMessage();

        GameManagerUI gm = new GameManagerUI();

        gm.play();

        players = gm.getJoining();

        //Creating Main Deck
        Deck playingDeck = new Deck();
        //Adding 52 ordered cards to the deck

        playingDeck.createDeck();
        //shuffling the Deck

        playingDeck.shuffle();
        int countForLoop = 0;
        //Main Game Loop
        do {

            if (countForLoop == 0) {
                gm.placingBets(players);
                countForLoop++;
            } else {
                System.out.println();
                blackjackView.moneyUpdate(players);
                gm.placingBets(players);

            }
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
