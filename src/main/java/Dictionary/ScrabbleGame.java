package Dictionary;

import java.util.ArrayList;
import java.util.List;

public class ScrabbleGame {
    private List<String> playedWords = new ArrayList<>();
    private List<Character> tiles = new ArrayList<>(); //7 tiles
    private ScrabbleDictionary dictionary = new ScrabbleDictionary();

    public ScrabbleGame(){
        //give the player 7 random tiles
    }


    /*If word exists in the scrabble dictionary and the letters exist in the tiles list
     * remove the letters from the list and add new random letters
     */
    public boolean playWord(String word) {
        return false;
    }
}
