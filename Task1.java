package Projects.CodeSoftInternship;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int attempts = 10;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int guess;
            int attemptCount = 0;
            
            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ".");
            
            while (attemptCount < attempts) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attemptCount++;
                
                if (guess < minRange || guess > maxRange) {
                    System.out.println("Please enter a number within the valid range.");
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attemptCount + " attempts.");
                    score++;
                    break;
                }
                
                if (attemptCount == attempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
                }
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);
        
        System.out.println("Thanks for playing! Your total score is: " + score);
        scanner.close();
    }
}
