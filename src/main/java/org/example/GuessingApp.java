package org.example;

import java.util.Scanner;

/**
 * MAIN CLASS
 * * Use Case 5: Game Result Storage
 * * This class coordinates the complete game flow
 * and persists the final result after completion.
 * * Responsibilities:
 * - Initialize game configuration
 * - Accept and validate user guesses
 * - Generate hints when applicable
 * - Store game result at the end
 *
 * @author seetharamaraju
 * @version 5.0
 */
public class GuessingApp {
    public static void main(String[] args) {

        System.out.println("Welcome To The Guessing App");
        GameConfiguration gameConfiguration = new GameConfiguration();
        gameConfiguration.showRules();

        Scanner scanner = new Scanner(System.in);
        /* * Player name is captured once * and stored along with game results. */
        System.out.print("Enter Player Name: ");
        String player = scanner.nextLine();

        int attempts = 0;
        int hintCount = 0;
        boolean win = false;

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
                    win = true;
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
        // * *Final game result is persisted * after the game loop completes. */
        StorageService.saveResult(player, attempts, win);

        if (win == false) {
            System.out.println("Completed ur Attempts : MAX:ATTEMPTS = " + gameConfiguration.getMaxAttempts() + "Used ATTEMPTS " + attempts);
            System.out.println("Good Luck Next Time !! ");
        }
        scanner.close();
    }
}
