package hangman;

/**
 *
 * @author ryang
 * 
 * Class used to handle bad input exceptions
 */

public class BadInputException extends Exception {

    /**
     * Creates a new instance of <code>BadInputException</code> without detail
     * message.
     */
    public BadInputException() {
    }

    /**
     * Constructs an instance of <code>BadInputException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BadInputException(String msg) {
        super(msg);
    }
}
