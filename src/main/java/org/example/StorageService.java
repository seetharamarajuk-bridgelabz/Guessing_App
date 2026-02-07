package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Use Case 5: Game Result Storage
 * <p>
 * This class is responsible for persisting
 * the final game result after the game ends.
 * <p>
 * Results are stored in a file so that
 * game history is not lost after exit.
 */
public class StorageService {

    /*
     * Saves the final outcome of the game.
     *
     * Each record contains:
     * - Player name
     * - Number of attempts used
     * - Win or loss result
     */
    public static void saveResult(String player, int attempts, boolean win) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("game_results.txt", true))) {

            writer.write("Player: " + player + ", Attempts: " + attempts + ", Result: " + (win ? "WIN" : "LOSE"));
            writer.newLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to save game result.");
        }
    }

}
