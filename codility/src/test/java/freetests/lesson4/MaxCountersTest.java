package freetests.lesson4;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class MaxCountersTest {

    private MaxCounters maxCounters;

    @Before
    public void setUp() {
        maxCounters = new MaxCounters();
    }

    @Test
    public void testMaxCounters() {
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, maxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
        assertArrayEquals(new int[]{3, 3, 3, 3, 3}, maxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 6}));
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, maxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));

        final int[] array = IntStream.range(1, 100_000).toArray();
        for (int i = 1; i < 8; i++) {
            array[i] = 1;
        }
        final int N = 99_998;
        assertEquals(N, maxCounters.solution(N, array).length);

        assertArrayEquals(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3}, maxCounters.solution(9, new int[]{1, 1, 1, 10, 10, 10, 10, 10, 10}));
        assertArrayEquals(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3}, maxCounters.solution(9, new int[]{1, 1, 1, 10, 10, 10, 10, 10, 10}));
        assertArrayEquals(new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, maxCounters.solution(10, new int[]{1, 1, 1, 1, 11, 11, 11, 11, 11, 11}));

        final int[] arrayAllMAxCounters = IntStream.range(1, 100_000).toArray();
        for (int i = 0; i < arrayAllMAxCounters.length; i++) {
            arrayAllMAxCounters[i] = 99_999;
        }
        assertEquals(99_999, maxCounters.solution(99_999, arrayAllMAxCounters).length);
    }
}
