package RPN;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RPNTest {

    @Test
    void basicEquation() {
        //given
        RPN equation = new RPN("3 4 +");
        //when
        String result=equation.evaluate();
        //then
        assertEquals("The total is 7.0", result);
    }


    @Test
    void complexEquation() {
        //given
        RPN equation = new RPN("3 4 * 2 +");
        //when
        String result=equation.evaluate();
        //then
        assertEquals("The total is 14.0", result);
    }

    @Test
    void error(){
        //given
        RPN equation = new RPN("3 4 + +");
        //when
        String result=equation.evaluate();
        //then
        assertEquals(RPN.ERROR,result);
    }
}