package math;

import org.junit.jupiter.api.Test;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

class QuadEquationTest {
    @Test
    public void findResultsRegular() {
        //given
        QuadEquation quad = new QuadEquation(5, 6, 1);
        //when
        double[] result = quad.findResults();
        //then
        double[] expected = {-0.2, -1.0};
        assertArrayEquals(expected, result);
    }

    @Test
    public void findResultsNaN() {
        //given
        QuadEquation quad = new QuadEquation(0, 2, 3);
        //when
        double[] result = quad.findResults();
        //then
        double[] expected = {NaN, NEGATIVE_INFINITY};
        assertArrayEquals(expected, result);
    }
}