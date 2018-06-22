package freetests.lesson2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CyclicRotationTest {

    private CyclicRotation cyclicRotation;

    @Before
    public void setUp() {
        cyclicRotation = new CyclicRotation();
    }

    @Test
    public void testCyclicRotation() {
//        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 3));
//        assertArrayEquals(new int[]{3, 8, 9, 7, 6}, cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 0));
//        assertArrayEquals(new int[]{3, 8, 9, 7, 6}, cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 5));
//        assertArrayEquals(new int[]{6, 3, 8, 9, 7}, cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 6));
        assertArrayEquals(new int[]{6, 3, 8, 9, 7}, cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 11));
//        assertArrayEquals(new int[]{6, 3, 8, 9, 7}, cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 16));
//        assertArrayEquals(new int[]{}, cyclicRotation.solution(new int[]{}, 1));
    }
}
