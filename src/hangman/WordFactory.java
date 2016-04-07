/**
 * 
 * @author ryang
 *
 * WordFactory class is designed to create a word based on difficulty, chosen by the user, and 
 * use an associated clue in its related array.  (e.g. wordsEasy is the word chosen & wordsEasyClue
 * is the associated clue)
 * 
 * Random is used to randomly select a word out of the respective difficulty arrays of strings and its 
 * respective clue.
 */

package hangman;
import java.util.Random;

public class WordFactory {

    public WordFactory() {

    }
    
    /**
     * 
     * @param difficulty <-- takes in difficulty from user selection in Main to sort through
     * if/else statement
     * @return <-- populates the Word class values at the same time of instantiation
     * @throws Exception <-- in case length of wordPool array does not equal cluePool array
     */
    
    public Word getWord(String difficulty) throws Exception {

        String[] wordPool;
        String[] cluePool;
        
        if (difficulty.equals("Easy")) {
            wordPool = WordFactory.wordsEasy;
            cluePool = WordFactory.wordsEasyClue;
        } else if (difficulty.equals("Medium")) {
            wordPool = WordFactory.wordsMedium;
            cluePool = WordFactory.wordsMediumClue;
        } else {
            wordPool = WordFactory.wordsHard;
            cluePool = WordFactory.wordsHardClue;
        }

        if (wordPool.length != cluePool.length) {
            throw new Exception("Clue pool does not match word pool length");
        }

        Random rand = new Random();
        int index = rand.nextInt(wordPool.length - 1);
        return new Word(wordPool[index], cluePool[index]);
    }

    /**
     * Arrays of type String to choose from varying difficulty levels and their associated clues
     * 
     * e.g. wordsEasy[2] is associated with the clue in wordsEasyClue[2]
     */
    
    static private final String[] wordsEasy = {"door", "phone", "bottle", "coffee", "paper", "shirt", "pants", "wheel",
            "square", "pizza"};

    static private final String[] wordsEasyClue = {"Open this to get into a room", "Makes calls", "It holds liquid",
            "The best part of waking up", "You write on this", "You wear this", "You wear this",
            "Part of a vehicle", "Not round", "You eat this"};

    static private final String[] wordsMedium = {"program", "sweatshirt", "razor", "tattoo", "pencil",
            "jacket", "mouse", "tiger", "monkey", "bear"};

    static private final String[] wordsMediumClue = {"What a computer runs", "Long-sleeved apparel",
            "Thin and sharp", "Permanent ink drawing", "Wood and graphite", "Wear this when cold", "Jerry",
            "Striped hunter", "Nature's clown", "Hangs out with lions and tigers"};

    static private final String[] wordsHard = {"wheelchair", "automobile", "firecracker", "cellular",
            "hemodynamics", "cardiomyopathy", "hypertrohy", "cardiology", "antidisestablishmentarianism",
            "echocardiography"};

    static private final String[] wordsHardClue = {"Round legs for those who can't walk", "A mode of transportation", "Fourth of July",
            "Type of phone we use", "The flow of blood", "Chronic disease of the heart muscle",
            "Abnormal enlargement of an organ or muscle", "The study of the heart", "World's 2nd longest word",
            "Ultrasound used to investigate the heart"};

}
