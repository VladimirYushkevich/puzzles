package freetests.lesson4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrogRiverOneTest {

    private FrogRiverOne frogRiverOne;

    @Before
    public void setUp() {
        frogRiverOne = new FrogRiverOne();
    }

    @Test
    public void testFrogRiverOne() {
        assertEquals(6, frogRiverOne.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
        assertEquals(-1, frogRiverOne.solution(5, new int[]{1, 3, 1, 4, 5, 3, 5, 4}));
        assertEquals(7, frogRiverOne.solution(5, new int[]{1, 3, 1, 4, 5, 3, 5, 2}));
        assertEquals(4, frogRiverOne.solution(5, new int[]{2, 3, 1, 4, 5, 3, 5, 1}));
    }
}
