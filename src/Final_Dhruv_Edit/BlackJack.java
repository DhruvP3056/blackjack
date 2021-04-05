/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Dhruv_Edit;

/**
 *
 * @author dhruvpatel
 */
import java.util.Scanner;
import java.util.ArrayList;

public class BlackJack {

    public static ArrayList<StandardPlayer> players = new ArrayList();

    public static void main(String[] args) {
        //scanner
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to BlackJack!!!");
        System.out.println();

        GameManager gm = new GameManager();
        gm.play();

        players = gm.getJoining();

        //Creating Main Deck
        Deck playingDeck = new Deck();
        //Adding 52 ordered cards to the deck
        playingDeck.createDeck();
        //shuffling the Deck
        playingDeck.shuffle();

        //Main Game Loop
        boolean playAgain = true;
        while (playAgain) {
            //PLacing Bets
            
            gm.placingBets(players);
            
       
            //dealercards will be created first
            Deck dealerCards = new Deck();
            //Giving two cards to dealer
            dealerCards.draw(playingDeck);
            dealerCards.draw(playingDeck);

            //ArrayList to hold the hands of the players
            ArrayList<Deck> playersDeck = new ArrayList();

            //Looping through each player
            for (StandardPlayer player : players) {

                //playerCards will be the player's hand
                Deck playerCards = new Deck();
                //Game starts now
                System.out.println();
                System.out.println("Dealing to " + player.getName());
                System.out.println();

                //Giving player two cards
                playerCards.draw(playingDeck);
                playerCards.draw(playingDeck);

                //while loop for hit or stand phase
                while (true) {
                    //Show Player Cards
                    System.out.println(player.getName() + " Your Hand: " + playerCards.toString());
                    System.out.println();

                    //getting User hand values
                    System.out.println(player.getName() + ": The Value of Your Cards is: " + playerCards.cardsValue());
                    System.out.println();

                    //showing one of dealers cards
                    System.out.println("Dealer's Hand: " + dealerCards.getCard(0).toString() + " and [Hidden]");
                    System.out.println();

                    //hit or stand phase
                    System.out.println();

                    System.out.println("Would you like to Hit or Stand?.....1 for Hit.....2 for Stand");

                    int userAnswer = in.nextInt();

                    //if they choose to hit(1)
                    if (userAnswer == 1) {
                        playerCards.draw(playingDeck);
                        System.out.println(player.getName() + " You drew a: " + playerCards.getCard(playerCards.deckSize() - 1).toString());
                        playersDeck.add(playerCards);

                        //Checking to see if value is now 21 after hitting
                        //if so then Player Busts
                        if (playerCards.cardsValue() > 21) {
                            System.out.println();
                            System.out.println(player.getName() + " You Busted. Your Value is " + playerCards.cardsValue());
                            player.setEndRound(true);
                            playersDeck.add(playerCards);
                            break;
                        }
                    }
                    //If they Choose Stand(2)
                    if (userAnswer == 2) {
                        playersDeck.add(playerCards);
                        break;
                    }
                }
            }

            //Showing Dealers Cards Now
            System.out.println();
            System.out.println("Dealer Cards: " + dealerCards.toString());

            boolean endRoundForDealer = false;

            //Dealer Keeps hitting until value above 16 and stands after that
            while ((dealerCards.cardsValue() < 17) && endRoundForDealer == false) {
                dealerCards.draw(playingDeck);
                System.out.println();
                System.out.println("Dealer Hits and Gets: " + dealerCards.getCard(dealerCards.deckSize() - 1).toString());
                if ((dealerCards.cardsValue() > 21)) {
                    endRoundForDealer = true;
                }
            }
            //Check to see If dealer has more points than player
            for (int i = 0; i < players.size(); i++) {
                if ((dealerCards.cardsValue() > playersDeck.get(i).cardsValue()) && endRoundForDealer == false ) {
                    System.out.println();

                    System.out.println("Dealer Won with a hand value of " + dealerCards.cardsValue() + " compared to " + players.get(i).getName() + "'s hand value of " + playersDeck.get(i).cardsValue());

                    players.get(i).setWallet(players.get(i).getWallet() - players.get(i).getCurrentBet());
                }

            }

            //Show Value Of Dealers Hand
            System.out.println("Dealer's Hand Value is " + dealerCards.cardsValue());

            //Check if dealer busted and only give money to players who did not bust aswell
            if (endRoundForDealer) {
                for (int i = 0; i < players.size(); i++) {
                    System.out.println();
                    if (playersDeck.get(i).cardsValue() < 22) {
                        System.out.println("Dealer Busts. You Win " + players.get(i).getName() + "!!!");

                        BalanceCalculator calculateWin = new BalanceCalculator();
                        players.get(i).setWallet(players.get(i).getWallet() + calculateWin.calculateBalance(players.get(i)));

                        //another way of adding money to wallet is
                        //players.get(i).setWaller(players.get(i).getWaller() + players.get(i).getCurrentBet());
                    } else if (endRoundForDealer == true && players.get(i).isEndRound() == true) {
                        System.out.println(players.get(i).getName() + " You Also Busted Like the Dealer ");
                        players.get(i).setWallet(players.get(i).getWallet() - players.get(i).getCurrentBet());
                    }
                }
            }

            //Check if Tie
            for (int i = 0; i < players.size(); i++) {

                if ((dealerCards.cardsValue() == playersDeck.get(i).cardsValue()) && endRoundForDealer == false) {
                    System.out.println("TIE!!!!!!");
                    System.out.println("Tie between the Dealer and " + players.get(i).getName());
                    System.out.println();
                }

                //Check if Players Won
                if ((playersDeck.get(i).cardsValue() > dealerCards.cardsValue()) && players.get(i).isEndRound() == false) {

                    System.out.println(players.get(i).getName() + " You Win this Hand.");
                    BalanceCalculator calculateWin = new BalanceCalculator();
                    players.get(i).setWallet(players.get(i).getWallet() + calculateWin.calculateBalance(players.get(i)));
                    //another way of adding money to wallet is
                    //players.get(i).setWaller(players.get(i).getWaller() + players.get(i).getCurrentBet());

                    //Once last players hand gets checked change value to true
                    if (i == players.size() - 1) {
                        endRoundForDealer = true;
                    }
                    //dealer wins
                } else if (endRoundForDealer == false && players.get(i).isEndRound() == true) {
                    System.out.println();
                    System.out.println("Dealer Wins!!!! against " + players.get(i).getName());
                    players.get(i).setWallet(players.get(i).getWallet() - players.get(i).getCurrentBet());
                }

            }

            //Printing Players Updated Money
            for (StandardPlayer money : players) {
                System.out.println();
                System.out.println("New Balance for " + money.getName());
                System.out.println();
                System.out.println("$" + money.getWallet());
                System.out.println();
                System.out.println();
            }
            System.out.println("End of Round");
            //Creating new Deck once the main deck is done
            if (playingDeck.deckSize() == 0) {
                playingDeck.createDeck();
                playingDeck.shuffle();
            }
            System.out.println("Play Again?");
            String userChoice = in.next();
            if (userChoice.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }

    }

}
