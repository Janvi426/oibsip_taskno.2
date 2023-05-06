// The number guessing game 
// Task - 2 (Oasis Infobyte)

import java.util.Random;
import javax.swing.JOptionPane;

public class TheNumGuessFinal {

    public static void main(String[] args) {
        int totalAttempts = 0;
        int totalWins = 0;
        int totalLosses = 0;

        do {
            int numAttempts = 0;
            int maxAttempts = 10;
            Random rand = new Random();
            int secretNumber = rand.nextInt(100) + 1;

            // Welcome massege
            JOptionPane.showMessageDialog(null,
                    "\t\tWELCOME TO THE GAME\nGuess the Number Game!\n\nPoints to be noted : \n- You have to enter a number between 1 to 100\n- If you get the massege 'Too High' then you \n  should add number less than the number entered before\n- If you get the massege 'Too Low' then you \n  should add number greater than the number entered before");

            while (numAttempts < maxAttempts) {
                String guessString = JOptionPane.showInputDialog(null, "Enter a number between 1 and 100:");
                int guess = Integer.parseInt(guessString);

                // invalid input
                if (guess < 1 || guess > 100) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number between 1 and 100.");
                    continue;
                }

                // if win
                if (guess == secretNumber) {
                    JOptionPane.showMessageDialog(null,
                            "Hurray! Congratulations! You guessed the number in " + (numAttempts + 1) + " attempts!");
                    totalAttempts += (numAttempts + 1);
                    totalWins++;
                    break;
                } else if (guess < secretNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }

                numAttempts++;
            }

            // if loss
            if (numAttempts == maxAttempts) {
                JOptionPane.showMessageDialog(null, "Oops! Game over! You have used up all " + maxAttempts
                        + " attempts. The secret number was " + secretNumber + ".");
                totalAttempts += maxAttempts;
                totalLosses++;
            }

            // ask for next game
            int playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again?");
            if (playAgain == JOptionPane.NO_OPTION) {
                break;
            }
        } while (true);

        // scorecard
        int totalGames = totalWins + totalLosses;
        double avgAttempts = (int) ((double) totalAttempts / totalGames);
        int score = 12 - (int) avgAttempts;
        JOptionPane.showMessageDialog(null,
                "HERE IS YOUR SCORECARD\nTotal games played : " + totalGames + "\nTotal wins : "
                        + totalWins + "\nTotal losses : " + totalLosses + "\nAverage attempts : " + avgAttempts
                        + "\nSCORE : " + score);
    }

}
