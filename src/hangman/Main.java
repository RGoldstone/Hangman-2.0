package hangman;

/**
 * @author ryang
 * 
 * Main is the class responsible for handling input/output of the Hangman game.
 * 
 * The user is able to select difficulty level, and communicates through the Hangman class to 
 * validate any and all input values against the randomly selected word/clue.
 */

import java.util.Scanner;


public class Main {

    static Scanner inputHandler;
    
    /**
     * Difficulty selection for the user which is sent to Hangman that routes it to 
     * WordFactory that then sends the value to Word and then back to Hangman.
     * 
     * The noose is then drawn and the guessing begins, adding a limb for each incorrect guess
     * 
     * If a correct guess is made, it appears in the string of dashes in place of one of the dashes
     * (The string of dashes symbolizes the word to guess)
     * 
     * The game will loop into another game if the users chooses after the previous game has finished,
     * or the user can choose to stop playing and the program will terminate.
     * 
     * @param args
     * @throws BadInputException <-- checks for bad input from the user
     */
    public static void main(String[] args) throws BadInputException {
        inputHandler = new Scanner(System.in);
        Boolean choice = false;
        do {
            String difficulty = "";
            String guess = "";
            Hangman hangman = new Hangman();
            System.out.println("Welcome to Hangman.\n");
            System.out.println("Please choose difficulty level: (E)asy||(M)edium||(H)ard");
            difficulty = inputHandler.nextLine();

            difficulty = difficulty.toLowerCase();
            switch (difficulty) {
                case "e":
                    difficulty = "Easy";
                    break;
                case "m":
                    difficulty = "Medium";
                    break;
                case "h":
                    difficulty = "Hard";
                    break;
            }
            
            try {
                hangman.setup(difficulty);
            } catch (Exception ex) {
                System.out.println("Oops, the programmer made a mistake in the defining of words. Contact him!");
                System.exit(1);
            }

            do {
            	hangman.draw();
                System.out.print(hangman.getGuessedWord());
                System.out.println("");
                System.out.println(hangman.getWordClue());
                System.out.println("\nGuess a letter!");
                
                guess = inputHandler.nextLine();
                
                if(guess == null || guess.isEmpty() || guess.length() > 1) {
                    System.out.println("Please input correct letter!");
                    continue;
                }
                
                Boolean isValidMove = hangman.guess(guess.toCharArray()[0]);
                
                System.out.print(hangman.getHiddenString());
                System.out.println("");
                System.out.println("Guesses: " + hangman.getGuessedWord());

                if(!isValidMove) {
                    hangman.badGuess();
                }
            } while (!hangman.hasWon() && !hangman.isGameOver());

            if (hangman.isGameOver()) {
                System.out.println("Sorry you lost!");
            } else {
                System.out.println("You Won!");
            }

            Boolean goodAnswer = true;
            do {
                String answer = "";

                System.out.println("=========================================");
                System.out.println("Would you like to play again? (Y)es||(N)o");
                System.out.println("=========================================");
                answer = inputHandler.nextLine();

                if (answer.equalsIgnoreCase("Y")) {
                    choice = true;
                    goodAnswer = true;
                } else if (answer.equalsIgnoreCase("N")) {
                    choice = false;
                    goodAnswer = true;
                    System.exit(0);
                } else {
                    goodAnswer = false;
                    System.out.println("Your answer \"" + answer + "\" should be Y or N.");
                }
            } while (!goodAnswer);
        } while (choice);
    }
}
