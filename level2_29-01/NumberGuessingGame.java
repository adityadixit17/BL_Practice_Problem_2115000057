import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    private static int lowerBound = 1;
    private static int upperBound = 100;
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Think of a number between 1 and 100, and I will try to guess it!");
        
        boolean guessedCorrectly = false;
        
        while (!guessedCorrectly) {
            int guess = generateGuess();
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct')");
            String feedback = scanner.next().toLowerCase();
            
            guessedCorrectly = processFeedback(guess, feedback);
        }
        
        System.out.println("Yay! I guessed your number!");
        scanner.close();
    }

    private static int generateGuess() {
        return lowerBound + random.nextInt(upperBound - lowerBound + 1);
    }

    private static boolean processFeedback(int guess, String feedback) {
        switch (feedback) {
            case "high":
                upperBound = guess - 1;
                break;
            case "low":
                lowerBound = guess + 1;
                break;
            case "correct":
                return true;
            default:
                System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
        }
        return false;
    }
}

