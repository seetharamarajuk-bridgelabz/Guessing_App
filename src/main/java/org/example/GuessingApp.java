package org.example;

import java.util.Scanner;

/**
 * MAIN CLASS
 * * Use Case 4: Error Handling & Validation
 * * This class coordinates the game execution while ensuring
 * all user inputs are safely validated before processing.
 * * Responsibilities:
 * - Initialize game configuration
 * - Accept user input
 * - Validate input using ValidationService
 * - Handle game flow without crashing on invalid input
 *
 * @author seetharamaraju
 * @version 4.0
 */

public class GuessingApp {
    public static void main(String[] args) {

        System.out.println("Welcome To The Guessing App");
        GameConfiguration gameConfiguration = new GameConfiguration();
        gameConfiguration.showRules();

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int hintCount = 0;

        /*
         * Game loop runs until the player
         * exhausts the maximum attempts.
         */
        while (attempts < gameConfiguration.getMaxAttempts()) {
            attempts++;
            System.out.print("Enter your guess: ");
            int guess = 0;
            try {
                guess = ValidateService.validateInput(scanner.nextLine());

                String result = GuessValidator.validateGuess(guess, gameConfiguration.getTargetNumber());

                System.out.println(result);

                /*
                 * Stop the loop immediately
                 * if the correct number is guessed.
                 */
                if (result.equals("CORRECT")) {
                    System.out.println("🎉 You won in " + attempts + " attempts!");
                    break;
                }

                if (hintCount < gameConfiguration.getMaxHints()) {
                    hintCount++;
                    System.out.println(HintService.generateHint(gameConfiguration.getTargetNumber(), hintCount));
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Completed ur Attempts : MAX:ATTEMPTS = " + gameConfiguration.getMaxAttempts() + "Used ATTEMPTS " + attempts);
        System.out.println("Good Luck Next Time !! ");
        scanner.close();
    }
}
