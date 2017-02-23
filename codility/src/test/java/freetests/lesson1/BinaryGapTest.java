package freetests.lesson1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryGapTest {

    private BinaryGap binaryGap;

    @Before
    public void init() {
        binaryGap = new BinaryGap();
    }

    @Test
    public void testBinaryGap() {
        assertEquals(0, binaryGap.solution(1)); //1000
        assertEquals(0, binaryGap.solution(8)); //0001
        assertEquals(2, binaryGap.solution(9)); //1001
        assertEquals(0, binaryGap.solution(15)); //1111
        assertEquals(0, binaryGap.solution(15)); //10100
        assertEquals(4, binaryGap.solution(529)); //1000010001
        assertEquals(1, binaryGap.solution(Integer.MAX_VALUE - 2)); //1111111111111111111111111111101
        assertEquals(0, binaryGap.solution(Integer.MAX_VALUE)); //1111111111111111111111111111111
    }

}
