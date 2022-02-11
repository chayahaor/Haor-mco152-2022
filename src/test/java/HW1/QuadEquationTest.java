package HW1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadEquationTest {
    @Test
    public void findResultsRegular() {
        //given
        QuadEquation quad = new QuadEquation(2, 2, 3);
        //when
        double[] result = quad.findResults();
        //then
        double[] expected = {};
        assertArrayEquals(expected, result);
    }

    @Test
    public void findResultsNaN() {
        //given
        QuadEquation quad = new QuadEquation(0, 2, 3);
        //when
        double[] result = quad.findResults();
        //then
        double[] expected = {};
        assertArrayEquals(expected, result);
    }
}