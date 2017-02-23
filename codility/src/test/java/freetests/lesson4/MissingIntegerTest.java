package freetests.lesson4;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class MissingIntegerTest {

    private MissingInteger missingInteger;

    @Before
    public void setUp() {
        missingInteger = new MissingInteger();
    }

    @Test
    public void testMissingInteger() {
        assertEquals(5, missingInteger.solution(new int[]{1, 3, 6, 4, 1, 2}));
        assertEquals(1, missingInteger.solution(new int[]{-1, -3, 0, -4, -1, -2}));
        assertEquals(2, missingInteger.solution(new int[]{-1, -3, 1, -4, -1, -2}));
        assertEquals(3, missingInteger.solution(new int[]{-1, -3, 1, -4, -1, 2}));
        assertEquals(1, missingInteger.solution(new int[]{-1, -3, 3, -4, -1, 2}));
        assertEquals(1, missingInteger.solution(new int[]{-1, -3, -6, -4, -1, -2}));
        assertEquals(1, missingInteger.solution(new int[]{-1, -3, -6, -4, -1, Integer.MAX_VALUE}));
        assertEquals(1, missingInteger.solution(new int[]{-1, -3, -6, -4, -1, 100000}));
        assertEquals(100001, missingInteger.solution(IntStream.range(1, 100000).toArray()));
        final int[] array = IntStream.range(1, 100000).toArray();
        array[49999] = -1;
        assertEquals(50000, missingInteger.solution(array));
        array[49999] = Integer.MAX_VALUE;
        assertEquals(50000, missingInteger.solution(array));
    }
}
