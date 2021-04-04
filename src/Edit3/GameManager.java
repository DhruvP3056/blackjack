/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edit3;

import New_Edit.*;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vigneshwar Premachandran
 * @author Zain Qureshi
 */
public class GameManager {

    private ArrayList<StandardPlayer> joining = new ArrayList();
    private ArrayList<Hand> hands = new ArrayList<>();
    Deck deck = new Deck();
    Hand DealerHand = new Hand(deck.getCards());

    public GameManager() {

    }

    //This method checks the Array of players and returns the player object corresponding to the passed name.
    public StandardPlayer getPlayerObject(ArrayList<StandardPlayer> players, String nameToCheck) {
        StandardPlayer temp = new StandardPlayer();
        for (StandardPlayer player : players) {
            if (player.getName().equalsIgnoreCase(nameToCheck)) {
                temp = player;
            }
        }
        return temp;
    }

    //This method returns whether the player name belongs to a player in the arraylist.
    public boolean doesPlayerExist(ArrayList<StandardPlayer> players, String nameToCheck) {
        int matchFound = 0;
        for (StandardPlayer player : players) {
            if (player.getName().equalsIgnoreCase(nameToCheck)) {
                matchFound++;
            }
        }
        return matchFound > 0;
    }

    public void play() {
        //Player registration
        boolean gameStart = false;
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to Blackjack!!!");
        do {
            System.out.println("Press ENTER to join " + joining.size() + "/4. "
                    + "Enter you NAME to leave the game. Enter \"Q\" to quit the game. "
                    + "Enter \"START\" to start the round.");
            String menuCommand = in.nextLine();

            //This command allows a player to join the game.
            if (menuCommand.equalsIgnoreCase("")) {
                StandardPlayer aPlayer = new StandardPlayer();
                System.out.println("Enter player name");
                String playerName = in.nextLine();
                if (playerName.equalsIgnoreCase("") || playerName.equalsIgnoreCase("start")) {
                    System.out.println("Please enter a valid name!");
                } else {
                    System.out.println(playerName + " has entered the game.");
                    aPlayer.setName(playerName);
                    joining.add(aPlayer);
                    Hand hand = new Hand(DealerHand.getOriginalDeck());
                    hands.add(hand);
                }

                //This command allows a user to quit the program.
            } else if (menuCommand.equalsIgnoreCase("Q")) {

                if (joining.size() == 0) {
                    do {
                        System.out.println("If you would like to quit the game, enter \"YES\"."
                                + "If you would like to go back press any button.");
                        if (in.nextLine().equalsIgnoreCase("YES")) {
                            System.out.println("Have a good day!");
                            exit(0);
                        } else {
                            break;
                        }
                    } while (joining.size() == 0);
                } else {
                    System.out.println("There are still " + joining.size() + " players in the game.");
                    System.out.println("Do you still want to quit? Enter \"YES\" to quit or press any button to return to the menu.");
                    if (in.nextLine().equalsIgnoreCase("YES")) {
                        System.out.println("Have a good day!");
                        exit(0);
                    }
                }

                //Use this command to allow a player to quit the game.    
            } else if (doesPlayerExist(joining, menuCommand)) {

                System.out.println(getPlayerObject(joining, menuCommand).getName() + " has left the game.");
                joining.remove(getPlayerObject(joining, menuCommand));

            } else if (menuCommand.equalsIgnoreCase("listPlayers")) {
                for (int i = 0; i < joining.size(); i++) {
                    System.out.println(joining.get(i).getName());
                }
            } else if (menuCommand.equalsIgnoreCase("start")) {
                gameStart = true;
            }

            //For testing
//            break;
        } while (gameStart == false);

        //Showing player balance
        System.out.println("The game is about to begin. Here is your Balance...");
        for (int i = 0; i < joining.size(); i++) {
            System.out.println(joining.get(i).toString() + " $" + joining.get(i).getWallet());
        }

        //Place your bets
        System.out.println("It's time to place your bets.");
        for (int i = 0; i < joining.size(); i++) {
            double toBet = 0;

            do {
                try {
                    System.out.println(joining.get(i).getName() + " Please enter the amount you would like to bet");
                    toBet = in.nextDouble();
                    if (toBet > 0 && toBet <= joining.get(i).getWallet()) {
                        joining.get(i).setCurrentBet(toBet);
                        System.out.println("you bet $" + joining.get(i).getCurrentBet());
                        break;
                    } else {
                        System.out.println("Please enter a valid bet amount!");
                    }
                } catch (Exception e) {

                    System.out.println("Please enter a valid number!");
                    in.next();
                }

            } while (joining.get(i).getCurrentBet() <= 0);

        }

        System.out.println();
        int count = 0;
        int count2 = 0;
        System.out.print("The dealer and each player will now be One card at a time\n");
        NaturalValidator validate = new NaturalValidator();

        while (count != joining.size() * 2) {

            DealerHand.addDealerCard();

            for (StandardPlayer player : joining) {
                Hand handOfPlayer = hands.get(count2);
                System.out.println();

                System.out.println(player.getName() + "  " + "Your Cards:");

                handOfPlayer.setUpdatedDeck(DealerHand.getUpdatedDeck());

                handOfPlayer.addUserCard();

                handOfPlayer.showUserHand();

                System.out.println();
                System.out.println();

                count++;

                count2++;
                handOfPlayer.setUpdatedDeck(DealerHand.getUpdatedDeck());

                if (count2 == joining.size()) {
                    count2 = 0;
                }
            }

            System.out.println();

            System.out.println("Dealers Cards");

            System.out.println();

            DealerHand.showDealerHand();
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("Hand Values");
        System.out.println();
        int count3 = 0;

        while (count3 < joining.size()) {
            Hand handOfPlayer = hands.get(count3);
            validate.validate(joining.get(count3), handOfPlayer.getuCards(), DealerHand.getdCards());
            if(validate.getResult().equalsIgnoreCase("uWin")){
                System.out.println("Win!!!");
            }
            validate.setResult("done");
            validate.validateNaturalWinner(joining.get(count3), handOfPlayer.getuCards(), DealerHand.getdCards(), DealerHand.getUpdatedDeck(), joining.size(), count3);
            handOfPlayer.setUpdatedDeck(validate.getCards());
            handOfPlayer.setuCards(validate.getuCards());
            handOfPlayer.setdCards(validate.getdCards());
            count3++;
        }

    }

}
