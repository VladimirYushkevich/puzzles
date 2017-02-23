package freetests.lesson5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinAvgTwoSliceTest {

    private MinAvgTwoSlice minAvgTwoSlice;

    @Before
    public void setUp() {
        minAvgTwoSlice = new MinAvgTwoSlice();
    }

    @Test
    public void testMinAvgTwoSlice() {
        assertEquals(1, minAvgTwoSlice.solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }
}
