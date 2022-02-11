package HW2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RPNTest {

    @Test
    void testBasicEquation() {
        //given
        RPN equation = new RPN("3 4 +");
        //when
        equation.evaluate();
        //then
        assertEquals("The total is 7.0", equation.toString());
    }


    @Test
    void testComplexEquation() {
        //given
        RPN equation = new RPN("3 4 * 2 +");
        //when
        equation.evaluate();
        //then
        assertEquals("The total is 14.0", equation.toString());
    }


    @Test
    void testExtraInfo() {
        //given
        RPN equation = new RPN("3 4 + 6");
        //when
        equation.evaluate();
        //then
        assertEquals("Extra junk ignored",equation.toString());
    }

    @Test
    void testError(){
        //given
        RPN equation = new RPN("3 4 + +");
        //when
        equation.evaluate();
        //then
        assertEquals("Please check your input. Something went wrong.",equation.toString());
    }
}