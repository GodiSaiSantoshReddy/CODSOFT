import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int roundsPlayed = 0;
        int roundsWon = 0;
        boolean keepPlaying = true;

        System.out.println("Welcome to the Guess the Number Game!");

        while (keepPlaying) {
            int target = rand.nextInt(100) + 1; // Number between 1 and 100
            int chances = 7;
            boolean isGuessed = false;

            System.out.println("\nI've picked a number between 1 and 100.");
            System.out.println("You have " + chances + " chances to guess it!");

            for (int i = 1; i <= chances; i++) {
                System.out.print("Guess " + i + ": ");
                int guess = input.nextInt();

                if (guess == target) {
                    System.out.println("Correct! You guessed it in " + i + " tries.");
                    isGuessed = true;
                    roundsWon++;
                    break;
                } else if (guess < target) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                System.out.println("Remaining attempts: " + (chances - i));
            }

            if (!isGuessed) {
                System.out.println("Oops! The correct number was " + target + ".");
            }

            roundsPlayed++;

            System.out.print("Want to play another round? (yes/no): ");
            input.nextLine(); // consume leftover newline
            String choice = input.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                keepPlaying = false;
            }
        }

        System.out.println("\nGame Finished!");
        System.out.println("Total Rounds Played: " + roundsPlayed);
        System.out.println("Rounds You Won: " + roundsWon);

        input.close();
    }
}
