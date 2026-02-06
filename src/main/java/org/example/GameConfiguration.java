package org.example;

import java.util.Random;


/**
 * Use Case 1: Game Initialization
 * <p>
 * This class is responsible for:
 * - Setting game boundaries
 * - Generating a random target number
 * - Displaying game rules
 * <p>
 * Demonstrates:
 * - Encapsulation
 * - Constructor initialization
 * - Random number generation
 */
public class GameConfiguration {

    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;
    private final int MAX_HINTS = 3;
    int targetNumber;

    public GameConfiguration() {
        Random random = new Random();
        this.targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    public int getMaxHints() {
        return MAX_HINTS;
    }

    public void showRules() {
        System.out.println("## Guess a number between " + MIN + " and " + MAX);
        System.out.println("## You have " + MAX_ATTEMPTS + " attempts.");
        System.out.println("## Hints will be provided after wrong guesses.\n");
    }
}