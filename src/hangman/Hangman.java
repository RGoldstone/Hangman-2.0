package hangman;

/**
 * 
 * @author ryang
 *
 * Hangman class takes the user input from Main and checks it against the word selected by the
 * difficulty value it sends to WordFactory, which in turn instantiates and populates the Word class 
 * with a word and its associated clue.  
 * 
 * Hangman also keeps track of the number of incorrect guesses, and calls the Draw method to add more
 * parts to the hangman drawing if another incorrect guess was made
 */

public class Hangman {

	private int incorrectGuesses;
	private int maxIncorrectGuesses;

	private Word secretWord;
	private String guessedWord = "";
    private String hiddenString;

	private WordFactory getWordFactory() {
		return new WordFactory();
	}

	public Hangman() {
	}

	/**
	 * Initial setup method for the secretWord, set maxIncorrectGuesses to 6
	 * @param difficulty
	 * @throws Exception
	 */
	public void setup(String difficulty) throws Exception {
		this.secretWord = this.getWordFactory().getWord(difficulty);
		this.maxIncorrectGuesses = 6;
		this.incorrectGuesses = 0;
	}

	/**
	 * Setup that handles the maxIncorrectGuesses
	 * @param difficulty
	 * @param maxIncorrectGuesses
	 * @throws Exception
	 */
	public void setup(String difficulty, int maxIncorrectGuesses) throws Exception {
		this.secretWord = this.getWordFactory().getWord(difficulty);
		this.maxIncorrectGuesses = maxIncorrectGuesses;
		this.incorrectGuesses = 0;
	}

	/**
	 * Checks to see if the number of incorrectGuesses exceeds the maxIncorrectGuesses
	 * @return
	 */
	public Boolean isGameOver() {
		return this.incorrectGuesses > this.maxIncorrectGuesses;
	}

	/**
	 * Checks and verifies if the secretWord equals the word in getHiddenString
	 * @return
	 */
	public Boolean hasWon() {
		return secretWord.getWord().equals(this.getHiddenString());
	}

	/**
	 * Add to guessed letters collection, then run against word model to see if it's in there
	 * If it's not then you increment incorrect guess - if it is, don't 
	 * @param letter
	 * @return
	 * @throws BadInputException
	 */
	public Boolean guess(char letter) throws BadInputException {     
	    String guess = String.valueOf(letter);
	    guessedWord += guess;
        
	    hiddenString = secretWord.getHiddenString(guessedWord.toCharArray());
	    
        return secretWord.getWord().contains(guess);
	}

	/**
	 * Handles incrementing of incorrectGuesses
	 */
    public void badGuess() {
        incorrectGuesses++;
    }
	
    /**
     * draw() draws the Hangman noose and subsequent body parts
     */
	public void draw() {
		char a = ' ';
		char b = ' ';
		char c = ' ';
		char d = ' ';
		char e = ' ';
		char f = ' ';
		char g = ' ';

		for (int i = 1; i <= incorrectGuesses; i++) {
			switch (i) {
			case 1:
				g = 'O';
				break;
			case 2:
				b = '|';
				break;
			case 3:
				a = '/';
				break;
			case 4:
				c = '\\';
				break;
			case 5:
				d = '|';
				break;
			case 6:
				e = '/';
				break;
			case 7:
				f = '\\';
				break;
			}
		}
		System.out.println(" |-----");
		System.out.println(" |    |");
		System.out.printf(" |    %s\n", g);
		System.out.printf(" |   %s%s%s \n", a, b, c);
		System.out.printf(" |    %s\n", d);
		System.out.printf(" |   %s %s \n", e, f);
		System.out.println(" | ");
		System.out.println("------------");
	}
	
	/**
	 * 
	 * @return getClue
	 */
	public String getWordClue() {
	    return secretWord.getClue();
	}

	/**
	 * 
	 * @return guessedWord
	 */
    public String getGuessedWord() {
        return guessedWord;
    }

    /**
     * 
     * @return hiddenString
     */
    public String getHiddenString() {
        return hiddenString;
    }
}
