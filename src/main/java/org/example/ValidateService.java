package org.example;

public class ValidateService {
    public static int validateInput(String input) throws InvalidInputException {
        try {
            int value = Integer.parseInt(input);

            // Check if the number is in the correct range
            if (value < 1 || value > 100) {
                throw new InvalidInputException("Number must be between 1 and 100");
            }

            return value; // If everything is fine, return the number

        } catch (NumberFormatException e) {
            // If the user entered text instead of a number, wrap it in your custom exception
            throw new InvalidInputException("Invalid input. Please enter numbers only.");
        }
    }
}
