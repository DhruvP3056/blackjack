/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.view;

/**
 *
 * @author dhruvpatel
 * @author Vigneshwar Premachandran
 * @author Zain Qureshi
 */
import blackjack.model.StandardPlayer;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

public class GameManagerUI {

    Scanner in; 

    public GameManagerUI() {
        in = new Scanner(System.in);
    }

    //-----------------------Utility Methods-----------------------------------
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

//--------------------------------------VIEW METHODS-----------------------------------------------------
    public String mainMenu(ArrayList<StandardPlayer> players) {

        //Main options
        System.out.println("Press \"ENTER\" to Join. " + players.size() + "/4 players in lobby.");
        System.out.println("Enter your \"NAME\" to leave the game.");
        System.out.println("Enter \"Q\" to quit the game.");
        System.out.println("Enter \"START\" to start the round.");

        //This is the main user input
        String menuCommand = in.nextLine();

        return menuCommand;
    }

    public StandardPlayer getPlayerRegistration() {
        StandardPlayer newPlayer = new StandardPlayer();
        String playerName;
        
        do{
        System.out.println("Enter player name");
        playerName = in.nextLine();

        if (playerName.equalsIgnoreCase("") || playerName.equalsIgnoreCase("start")) {

            System.out.println("Please enter a valid name!");

        } else {
            System.out.println(playerName + " has entered the game.");
            newPlayer.setName(playerName);
        }
        }while(playerName.equalsIgnoreCase("") || playerName.equalsIgnoreCase("start"));

        return newPlayer;
    }

    public void quitGame(ArrayList<StandardPlayer> players) {
        if (players.size() == 0) {

            System.out.println("Are you sure you want to quit?");
            System.out.println("Enter \"YES\" to quit");
            System.out.println("If you would like to go back press \"ENTER\".");

            if (in.nextLine().equalsIgnoreCase("YES")) {
                System.out.println("Have a good day!");
                exit(0);
            }

        } else {
            System.out.println("There are still " + players.size() + " players in the game.");

            System.out.println("Are you sure you want to quit?");
            System.out.println("Enter \"YES\" to quit");
            System.out.println("If you would like to go back press \"ENTER\".");

            if (in.nextLine().equalsIgnoreCase("YES")) {
                System.out.println("Have a good day!");
                exit(0);
            }
        }
    }

    public void showAllPlayerBalance(ArrayList<StandardPlayer> players) {
        System.out.println("Now showing balance for all players:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).toString() + " $" + players.get(i).getWallet());
        }
    }

    public void tutorial(){
        System.out.println("Welcome to Super BlackJack!!!");
        int option = 2;
        
        do{
        try{  
            System.out.println("Enter \"1\" to view the tutorial, or \"0\" to begin the game.");
            option = in.nextInt();
            
            if(option == 1){
                System.out.println("---Basic Rules---");
                System.out.println("BlackJack is a game where the players face the dealer, as opposed to each other.\n"
                        + "Number cards have point values equal to their numbers, face cards have a value of 10, \n"
                        + "and Aces have a value of 1 or 11. The goal of the game is to have a hand value close to or \n"
                        + "exactly 21 points without exceeding 21.");
                System.out.println("");
                System.out.println("---How the Game Runs---");
                System.out.println("All players including the dealer will first be dealt 1 card face up. Next, all players except the\n"
                        + "dealer will be dealt 1 card face up. The dealer is also dealt the second card but it is not face up. Once\n"
                        + "two cards have been dealt, the dealer will ask each player to \"hit\" or \"stand\", where hit means to be dealt\n"
                        + "a card and stand means to pass. Players will hit until they are satisfied with their hand value or exceed 21 points.\n"
                        + "Once all players, including the dealer have gone through this process, the dealer will compare the value of their\n"
                        + "hand with each player. If the player has a hand value greater than the dealer, they win. If the dealer has more points\n"
                        + "than the player, the dealer wins. If both sides have the same points, the round is tied. Players who have a value of \n"
                        + "21 points in their hand automatically win on their turn.");
                System.out.println("");
                System.out.println("---Super BlackJack Rules---");
                System.out.println("In Super BlackJack there are two additional cards in the deck, a pair of jokers. When drawn, the joker comes into\n"
                        + "play as a copy of another card in the players hand, except under two conditions. If the player's hand is empty, the Joker's\n"
                        + "value is 1. If the player already has a Joker in their hand, they bust automatically. The player is allowed to choose\n"
                        + "which card in their hand the joker becomes.");
                System.out.println("---End of Tutorial---");
                System.out.println("");
                System.out.println("");
                break;
            }else if(option == 0){
                System.out.println("---Initiallizing Player Registration---");
                break;
            }
        }catch(Exception e){
            in.next();
        }
        }while(option != 1 || option != 0);
    }
    
    //Placing bets
    public void placingBets(ArrayList<StandardPlayer> players) {
        System.out.println("It's time to place your bets.");
        for (int i = 0; i < players.size(); i++) {
            
            double toBet = 0;

            do {
                try {
                    System.out.println(players.get(i).getName() + " Please enter the amount you would like to bet");
                    toBet = in.nextDouble();
                    if (toBet > 0 && toBet <= players.get(i).getWallet()) {
                        players.get(i).setCurrentBet(toBet);
                        System.out.println("you bet $" + players.get(i).getCurrentBet());
                        break;
                    } else {
                        System.out.println("Please enter a valid bet amount!");
                    }
                } catch (Exception e) {

                    System.out.println("Please enter a valid number!");
                    in.next();
                }

            } while (players.get(i).getCurrentBet() <= 0);

        }
    }

}