import java.util.*;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 4;
        int rounds = 0;
        int totalAttempts = 0;

        boolean playAgain = true;
        while (playAgain) {
            rounds++;
            int number = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Round " + rounds + ":");
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == number) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number " + number + " correctly in " + attempts + " attempts!");
                    break;
                } else if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + number);
            }

            totalAttempts += attempts;
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        scanner.close();
        double averageAttempts = (double) totalAttempts / rounds;
        System.out.println("Game over! Your average number of attempts per round was: " + averageAttempts);
    }
}