package freetests.lesson5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassingCarsTest {

    private PassingCars passingCars;

    @Before
    public void setUp() {
        passingCars = new PassingCars();
    }

    @Test
    public void testPassingCars() {
        assertEquals(5, passingCars.solution(new int[]{0, 1, 0, 1, 1}));
        assertEquals(2, passingCars.solution(new int[]{1, 1, 0, 1, 1}));
        assertEquals(6, passingCars.solution(new int[]{0, 0, 1, 1, 1}));
    }
}
