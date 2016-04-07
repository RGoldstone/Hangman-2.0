package hangman;

/**
 * @author ryang
 * 
 * Word class receives a randomly generated word from WordFactory
 * 
 * Word is put into the getHiddenString() method to produce an array of characters with dashes in it's 
 * place to use as a hint for the word in the Hangman game itself
 */

import java.util.Arrays;


public class Word {

    private int wordLength;
    private String word = "";
    private String clue = "";

    public Word(String word, String clue) {
        this.word = word;
        this.clue = clue;
        this.wordLength = word.length();
    }
    
    /**
     * 
     * @param guessedLetters
     * @return hiddenStringAsArray
     * 
     * Compares the guessed letters to the letters in randomly selected word and replaces the initial
     * dashes with the correctly guessed letters
     */
    public String getHiddenString(char[] guessedLetters) {
        char[] wordAsChars = this.word.toCharArray();
        char[] hiddenStringAsArray = new char[wordLength];
        Arrays.fill(hiddenStringAsArray, '_');

        for(int i = 0; i < guessedLetters.length; ++i) {
            for(int j = 0; j < wordLength; ++j) {
                if (wordAsChars[j] == guessedLetters[i]) {
                    hiddenStringAsArray[j] = wordAsChars[j];
                }
            }
        }
        
        return new String(hiddenStringAsArray);
    }
    
    /**
     * 
     * @return the clue
     */
    public String getClue() {
        return clue;
    }
    
    /**
     * 
     * @param clue
     */
    public void setClue(String clue) {
        this.clue = clue;
    }

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }
}