package Dictionary;

import java.util.Random;

public class LetterPool {

    private Random generator = new Random();


    public char getRandomLetter() {
        int number = generator.nextInt(26) + 65; //generates a number up to 26
        // then adds 65 to convert it to the ascii value of a capital letter
        return (char) number;

    }

}
