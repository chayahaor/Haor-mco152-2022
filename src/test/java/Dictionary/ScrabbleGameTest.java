package Dictionary;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleGameTest {
    ScrabbleDictionary dictionary = Mockito.mock(ScrabbleDictionary.class);
    LetterPool letterPool = Mockito.mock(LetterPool.class);

    @Test
    void playWord_True() {
        //given
        Mockito.doReturn(true).when(dictionary).isWord("HELLO");
        Mockito.doReturn('H', 'E', 'L', 'L', 'O', 'O', 'O').
                when(letterPool).getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);
        String word = "HELLO";
        //when
        //then
        assertTrue(game.playWord(word));
        Mockito.verify(letterPool, Mockito.times(7+5)).getRandomLetter();
        assertTrue(game.playedWords.contains(word));
        assertEquals(game.playedWords.size(),1);
        assertEquals(7, game.tiles.size());
    }


    @Test
    void playWord_False() {
        //given
        Mockito.doReturn(true).when(dictionary).isWord("LOGO");
        Mockito.doReturn('H', 'E', 'L', 'L', 'O', 'O', 'O').
                when(letterPool).getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);
        String word = "LOGO";
        //when
        //then
        assertFalse(game.playWord(word));
        assertTrue(game.playedWords.isEmpty());
        Mockito.verify(letterPool, Mockito.times(7)).getRandomLetter();
        assertEquals(7, game.tiles.size());
    }


    @Test
    void playWord_NotInDictionary() {
        //given
        Mockito.doReturn('H', 'E', 'L', 'L', 'O', 'O', 'O').
                when(letterPool).getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);
        String word = "HEL";
        //when
        boolean val = game.playWord(word);
        //then
        Mockito.verify(dictionary).isWord(word);
        assertFalse(val);
        assertTrue(game.playedWords.isEmpty());

    }

}