package dictionary;

import java.util.ArrayList;
import java.util.List;

public class ScrabbleGame {
    List<String> playedWords = new ArrayList<>();
    List<Character> tiles = new ArrayList<>();
    ScrabbleDictionary dictionary;
    LetterPool letterPool;
    String dictionaryAndTilesFound;
    static final String win = "You got it";
    static final String notInDictionary = "Word not found in dictionary";
    static final String notInTiles = "Word not found in tiles";


    public String getDictionaryAndTilesFound() {
        return dictionaryAndTilesFound;
    }

    //give the player 7 random tiles
    public ScrabbleGame(ScrabbleDictionary dictionary, LetterPool letterPool) {
        this.dictionary = dictionary;
        this.letterPool = letterPool;
        for (int i = 0; i < 7; i++)
        {
            tiles.add(letterPool.getRandomLetter());
        }

    }

    /*If word exists in the scrabble dictionary and the letters exist in the tiles list
     * remove the letters from the list and add new random letters
     */
    public boolean playWord(String word) {
        String capitalWord = word.toUpperCase();

        if (checkIfInTiles(word))
        {
            if (dictionary.isWord(capitalWord))
            {
                playedWords.add(capitalWord);
                for (int i = 0; i < word.length(); i++)
                {
                    char letter = word.charAt(i);
                    tiles.remove(tiles.indexOf(letter));

                }
                for (int j = 0; j < word.length(); j++)
                {
                    tiles.add(letterPool.getRandomLetter());
                }
                dictionaryAndTilesFound = win;
                return true;
            }
            dictionaryAndTilesFound = notInDictionary;
        } else
        {
            dictionaryAndTilesFound = notInTiles;
        }
        return false;
    }

    private boolean checkIfInTiles(String word) {
        ArrayList<Character> charTiles = new ArrayList<>(tiles);
        for (int i = 0; i < word.length(); i++)
        {
            int spot = charTiles.indexOf(word.charAt(i));
            if (spot == -1)
            {
                return false;
            } else
            {
                charTiles.remove(spot);
            }
        }
        return true;
    }

    public List<String> returnPlayedWords() {
        return playedWords;
    }


}
