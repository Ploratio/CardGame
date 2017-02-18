package Game;

import java.util.Scanner;


public class UI {


    public static void main(String args[]) {
        Boolean appRunning = true;
        String input;

        while (appRunning) {
            System.out.println( "Welcome to the Card Game!\n" +
                                "    1. New game\n" +
                                "    9. Exit");
            input = getInput();
            if (input.equals("9")) {
                System.out.println("Goodbye!");
                appRunning = false;
            } else if (input.equals("1")) {
                System.out.println("Starting a new game!");
                Game g = new Game();
                while (g.gameInProgress) {
                    System.out.println();
                    System.out.println( "Select your next action\n" +
                                        "    1. Play your next card\n" +
                                        "    9. Exit game");
                    input = getInput();
                    if (input.equals("1")) {
                        g.playerPlaysCard();
                        g.doWeHaveWinner();

                    } else if (input.equals("9")) {
                        System.out.println("Exiting game...");
                        System.out.println();
                        g.gameInProgress = false;
                    }
                }
            }
        }
    }


    private static String getInput() {
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

}
