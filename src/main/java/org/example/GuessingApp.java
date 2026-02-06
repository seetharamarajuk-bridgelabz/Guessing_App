package org.example;

/**
 * GuessingApp - Use Case 1: Game Initialization
 * <p>
 * This class serves as the application entry point.
 * It initializes the game configuration and displays game rules.
 * <p>
 * No user input or gameplay logic is implemented at this stage.
 *
 * @author seetharamaraju
 * @version 1.0
 */
public class GuessingApp {
    public static void main(String[] args) {

        System.out.println("Welcome To The Guessing App");
        GameConfiguration gameConfiguration = new GameConfiguration();
        gameConfiguration.showRules();

    }
}
