/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vigneshwar Premachandran
 */
public class GameManager extends Game {

    public GameManager() {
    }

    //This method checks the Array of players and returns the player object corresponding to the passed name.
    public StandardPlayer getPlayerObject(ArrayList<StandardPlayer> players, String nameToCheck){
        StandardPlayer temp = new StandardPlayer();
        for(StandardPlayer player:players){
            if(player.getName().equalsIgnoreCase(nameToCheck)){
                temp = player;
            }
        }
        return temp;
    }
    
    //This method returns whether the player name belongs to a player in the arraylist.
    public boolean doesPlayerExist(ArrayList<StandardPlayer> players, String nameToCheck){
        int matchFound = 0;
        for(StandardPlayer player:players){
            if(player.getName().equalsIgnoreCase(nameToCheck)){
                matchFound++;
            }
        }
        return matchFound > 0;
    }
    
    @Override
    public void play() {
        //Player registration
        boolean gameStart = false;
        ArrayList<StandardPlayer> joining = new ArrayList();
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
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
