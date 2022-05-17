package rpn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RpnTest {

    @Test
    void basicEquation() {
        //given
        Rpn equation = new Rpn("3 4 +");
        //when
        String result=equation.evaluate();
        //then
        assertEquals("The total is 7.0", result);
    }


    @Test
    void complexEquation() {
        //given
        Rpn equation = new Rpn("3 4 * 2 +");
        //when
        String result=equation.evaluate();
        //then
        assertEquals("The total is 14.0", result);
    }

    @Test
    void error(){
        //given
        Rpn equation = new Rpn("3 4 + +");
        //when
        String result=equation.evaluate();
        //then
        assertEquals(Rpn.ERROR,result);
    }
}