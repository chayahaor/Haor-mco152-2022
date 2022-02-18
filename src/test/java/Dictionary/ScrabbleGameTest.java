package Dictionary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleGameTest {

    @Test
    void playWord() {
        //given
        ScrabbleGame game = new ScrabbleGame();
        //when
        String word = "happy";
        //then
        assertTrue(game.playWord(word)); //Set original tiles to include 'happy'
        assertFalse(game.playWord(word)); //once used, very unlikely that the tiles were replaced with the same ones
    }
}