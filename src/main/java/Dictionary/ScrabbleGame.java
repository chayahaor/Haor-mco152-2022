package Dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScrabbleGame {
    private List<String> playedWords = new ArrayList<>();
    private List<Character> tiles = new ArrayList<>();
    private Random generator = new Random();

    //give the player 7 random tiles
    public ScrabbleGame() {
        //addTiles(7);
        tiles.add('a');
        tiles.add('h');
        tiles.add('g');
        tiles.add('p');
        tiles.add('y');
        tiles.add('p');
        tiles.add('e');
        //When not testing, should use the following line of code:
        //addTiles(7);
    }

    /*If word exists in the scrabble dictionary and the letters exist in the tiles list
     * remove the letters from the list and add new random letters
     */
    public boolean playWord(String word) {
        String capitalWord = word.toUpperCase();
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        if (checkIfInTiles(word) && dictionary.isWord(capitalWord))
        {
            playedWords.add(capitalWord);
            for (int i = 0; i < word.length(); i++)
            {
                char letter = word.charAt(i);
                tiles.remove(tiles.indexOf(letter));
                addTiles(word.length());
            }
            return true;
        }
        return false;
    }

    private boolean checkIfInTiles(String word) {
        ArrayList<Character> charTiles = new ArrayList<>(tiles); 
        for (int i = 0; i < word.length(); i++)
        {
            if (!charTiles.contains(word.charAt(i)))
            {
                return false;
            }
            else{
                charTiles.remove(charTiles.indexOf(word.charAt(i)));
            }
        }
        return true;
    }

    public List<String> returnPlayedWords() {
        return playedWords;
    }

    private void addTiles(int length) {
        int number;
        for (int i = 0; i < length; i++)
        {
            number = generator.nextInt(26)+65; //generates a number up to 26
            // then adds 65 to convert it to the ascii value of a capital letter
            tiles.add((char) number);
        }
    }


}
