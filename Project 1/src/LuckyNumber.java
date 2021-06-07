/* This file was written by phoitran on 04/09/2021 */
import java.util.Random;
import java.util.Scanner;

public class LuckyNumber {
    public static int max = 50;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random rd = new Random();
        String ans;
        int totalGame = 0, totalGuess = 0, bestGame = 0, myNumber, inGameGuess;
        double guessAvg;
        do {

            myNumber = rd.nextInt(max);             // Get a random interger from zero to maximum for each game.
            System.out.println("I'm thinking of a number between 0 and " + max + "...");
            inGameGuess= play(myNumber, input);
            System.out.print("Tiep tuc nhe?");    // ask for one more game
            ans = input.next().toLowerCase();
            totalGuess += inGameGuess;              // This is total guesses of every game.
            totalGame += 1;                         // This is total game of every run.
            if (totalGame == 1){                    // check condition for best game. fewer guess, better game
                bestGame = inGameGuess;
            } else {
                if (bestGame > inGameGuess){
                    bestGame = inGameGuess;
                }
            }
        } while (ans.equals("yes") || ans.equals("y")); // check condition for another game play.
        guessAvg = (double) totalGuess / totalGame;
        System.out.println();
        report(totalGame,totalGuess,guessAvg,bestGame); // print a report after quit the game.
    }

/*This code handle the core of game.
* It get an input and assign to yourGuess, compare with myNumber (random),
* give a clue to user for guessing myNumber  */
    public static int play(int myNumber, Scanner input){
        int yourGuess = -1, guessCounting = 0;
        while (yourGuess != myNumber) {
            System.out.print("Your guess? ");
            yourGuess = input.nextInt();
            if (yourGuess > myNumber){
                System.out.println("It's lower.");
            } else {
                System.out.println("It's higher.");
            }
            guessCounting += 1;
        }
        System.out.println("You got it right in " + guessCounting + " guesses!");
        System.out.println();
        return guessCounting;
    }

/* This method will print a report after the user want to stop the game.
* There are 4 variables in this method: totalGuess, totalGame, guessAvg and bestGame */
    public static void report(int totalGame, int totalGuess, double guessAvg, int bestGame){
        System.out.println("Overall results:");
        System.out.println("Total game      = " + totalGame);
        System.out.println("Total guess     = " + totalGuess);
        System.out.println("Guesses/Game    = " + guessAvg);
        System.out.println("Best game       = " + bestGame);
    }
}