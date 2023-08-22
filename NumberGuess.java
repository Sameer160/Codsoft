import java.util.Scanner;
import java.util.Random;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int round = 1;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (true) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            
            System.out.println("\nRound " + round + ":");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (between " + minRange + " and " + maxRange + "): ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1);
                    break;
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Round over! The correct number was " + targetNumber + ". You've used all your attempts.");
            }
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (playAgain.equalsIgnoreCase("no")) {
                break;
            }
            
            round++;
        }
        
        System.out.println("Game over! Your total score is: " + score);
        scanner.close();
    }
}
