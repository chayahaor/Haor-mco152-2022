package HW1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectileTest {

    @Test
    public void getX() {
        //given - set up all variables and conditions
        Projectile p = new Projectile(52, 17);

        //when - where the test actually happens
        double x = p.getX(3);

        //then - where check results
        assertEquals(31.3987, x, 0.0001);
    }

    @Test
    public void getY(){
        //given - set up all variables and conditions
        Projectile p = new Projectile(52, 17);

        //when - where the test actually happens
        double x = p.getY(3);

        //then - where check results
        assertEquals(-3.9114, x, 0.0001);
    }


}