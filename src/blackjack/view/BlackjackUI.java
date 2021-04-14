/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.view;

import blackjack.BalanceCalculator;
import blackjack.model.Deck;
import blackjack.model.StandardPlayer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Amanda Jose, 2021
 */
public class BlackjackUI {

    Scanner input;
    private static boolean endRoundForDealer = false;
    private static boolean dealerNaturalWin = false;

    public BlackjackUI() {
        input = new Scanner(System.in);
    }

    public void startMessage() {
        System.out.println("Welcome to BlackJack!!!");
        System.out.println();
    }

    public void startGame(ArrayList<StandardPlayer> players, Deck playingDeck, Deck dealerCards, ArrayList<Deck> playersDeck) {
        for (StandardPlayer player : players) {

            Deck playerCards = new Deck();
            System.out.println("\nDealing to " + player.getName() + "\n");

            //Giving player two cards
            playerCards.draw(playingDeck);
            playerCards.draw(playingDeck);

            //Checking to see if player has a natural win
            if (playerCards.cardsValue() == 21) {
                player.setNaturalWin(true);
                System.out.println();
                playerCards.toString();
                System.out.println();
                System.out.println("You Have A Natural Win!!!!");
                continue;
            }

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

                int userAnswer = input.nextInt();

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
    }

    public void showDealersCards(Deck dealerCards) {
        System.out.println("\nDealer Cards: " + dealerCards.toString());
    }

    public void didDealerWin(Deck dealerCards, Deck playingDeck, ArrayList<Deck> playersDeck, ArrayList<StandardPlayer> players) {

        //Checking Dealers hand for Natural Win
        if (dealerCards.cardsValue() == 21) {
            dealerNaturalWin = true;
        } else {
            //Dealer Keeps hitting until value above 16 and stands after that
            while ((dealerCards.cardsValue() < 17) && endRoundForDealer == false) {
                dealerCards.draw(playingDeck);
                System.out.println();
                System.out.println("Dealer Hits and Gets: " + dealerCards.getCard(dealerCards.deckSize() - 1).toString());
                System.out.println();
                dealerCards.toString();
                if ((dealerCards.cardsValue() > 21)) {
                    endRoundForDealer = true;
                }
            }
        }

        //Check to see If dealer has more points than player
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).isNaturalWin() == true) {
                continue;
            }
            if ((dealerCards.cardsValue() > playersDeck.get(i).cardsValue()) && endRoundForDealer == false) {

                System.out.println();

                if (dealerNaturalWin) {

                    System.out.println("Dealer Won with a Natural Win and a hand value of " + dealerCards.cardsValue() + " compared to " + players.get(i).getName() + "'s hand value of " + playersDeck.get(i).cardsValue());

                    players.get(i).setWallet(players.get(i).getWallet() - players.get(i).getCurrentBet());

                } else {

                    System.out.println("Dealer Won with a hand value of " + dealerCards.cardsValue() + " compared to " + players.get(i).getName() + "'s hand value of " + playersDeck.get(i).cardsValue());

                    players.get(i).setWallet(players.get(i).getWallet() - players.get(i).getCurrentBet());

                }
            }

        }
    }

    public void showDealersHandValue(Deck dealerCards) {

        System.out.println("Dealer's Hand Value is " + dealerCards.cardsValue());

    }

    public void isBusted(Deck dealerCards, ArrayList<Deck> playersDeck, ArrayList<StandardPlayer> players) {

        //Check if dealer busted and only give money to players who did not bust aswell
        if (endRoundForDealer) {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).isNaturalWin() == true) {
                    continue;
                }
                System.out.println();
                if (playersDeck.get(i).cardsValue() < 22) {
                    System.out.println();
                    System.out.println("Dealer Busts. You Win " + players.get(i).getName() + "!!!");

                    BalanceCalculator calculateWin = new BalanceCalculator();
                    players.get(i).setWallet(players.get(i).getWallet() + calculateWin.calculateBalance(players.get(i)));
                    //another way of adding money to wallet is
                    //players.get(i).setWaller(players.get(i).getWaller() + players.get(i).getCurrentBet());
                } else if (endRoundForDealer == true && players.get(i).isEndRound() == true) {
                    System.out.println();
                    System.out.println(players.get(i).getName() + " You Also Busted Like the Dealer ");
                    players.get(i).setWallet(players.get(i).getWallet() - players.get(i).getCurrentBet());
                }
            }
        }
    }

    public void winChecker(Deck dealerCards, ArrayList<Deck> playersDeck, ArrayList<StandardPlayer> players) {
        //checking for tie
        for (int i = 0; i < players.size(); i++) {

            if (players.get(i).isNaturalWin() == true && dealerNaturalWin == true) {

                System.out.println("TIE!!!!!!");
                System.out.println("Natural Win Tie between the Dealer and " + players.get(i).getName());
                System.out.println();
                continue;

            }
            if ((dealerCards.cardsValue() == playersDeck.get(i).cardsValue()) && endRoundForDealer == false) {
                System.out.println("TIE!!!!!!");
                System.out.println("Tie between the Dealer and " + players.get(i).getName());
                players.get(i).setTie(true);
                System.out.println();
                continue;
            }

            if ((playersDeck.get(i).cardsValue() > dealerCards.cardsValue()) && players.get(i).isEndRound() == false) {
                
                if (players.get(i).isNaturalWin() == true) {
                    
                    BalanceCalculator calculateNaturalWin = new BalanceCalculator();
                    
                    players.get(i).setWallet(calculateNaturalWin.calculateNaturalWinBalance(players.get(i)));
                    
                    System.out.println(players.get(i).getName() + " You Won With a Natural Hand!!");
                    
                    continue;
                }
                System.out.println();
                System.out.println(players.get(i).getName() + " You Win this Hand.");
                BalanceCalculator calculateWin = new BalanceCalculator();
                players.get(i).setWallet(players.get(i).getWallet() + calculateWin.calculateBalance(players.get(i)));
                //another way of adding money to wallet is
                //players.get(i).setWaller(players.get(i).getWaller() + players.get(i).getCurrentBet());

                //Once last players hand gets checked change value to true
                if (i == players.size() - 1) {
                    endRoundForDealer = true;
                } //dealer wins
            } else if (endRoundForDealer == false && players.get(i).isEndRound() == true) {
                if (dealerNaturalWin == true) {
                    System.out.println();
                    System.out.println("Dealer Wins with a Natural Win!!!! against " + players.get(i).getName());
                    players.get(i).setWallet(players.get(i).getWallet() - players.get(i).getCurrentBet());
                }
                System.out.println();
                System.out.println("Dealer Wins!!!! against " + players.get(i).getName());
                players.get(i).setWallet(players.get(i).getWallet() - players.get(i).getCurrentBet());

            }

        }
    }

    public void moneyUpdate(ArrayList<StandardPlayer> players) {
        for (StandardPlayer player : players) {
            System.out.println("\nNew Balance for " + player.getName() + " is ");
            System.out.println("$" + player.getWallet() + "\n\n");
        }
    }

    public boolean newRound(Deck playingDeck) {
        System.out.println("End of Round");
        //Creating new Deck once the main deck is done
        if (playingDeck.deckSize() == 0) {
            playingDeck.createDeck();
            playingDeck.shuffle();
        }
        System.out.println("Play Again?");
        String userChoice = input.next();
        return userChoice.equals("yes");
    }
}
