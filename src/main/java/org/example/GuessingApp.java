package org.example;

import java.util.Scanner;

/**
 * MAIN CLASS
 * * Coordinates the game flow:
 * 1. Initialize game
 * 2. Accept user guesses
 * 3. Validate guesses
 * 4. Stop when game ends
 *
 * @author seetharamaraju
 * @version 2.0
 */

public class GuessingApp {
    public static void main(String[] args) {

        System.out.println("Welcome To The Guessing App");
        GameConfiguration gameConfiguration = new GameConfiguration();
        gameConfiguration.showRules();

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        /*
         * Game loop runs until the player
         * exhausts the maximum attempts.
         */
        while (attempts < gameConfiguration.getMaxAttempts()) {

            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            String result = GuessValidator.validateGuess(guess, gameConfiguration.getTargetNumber());

            System.out.println(result);

            /*
             * Stop the loop immediately
             * if the correct number is guessed.
             */
            if (result.equals("CORRECT")) {
                break;
            }
        }
    }

}
