package freetests.lesson3;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class PermMissingElemTest {

    private PermMissingElem permMissingElem;

    @Before
    public void setUp() {
        permMissingElem = new PermMissingElem();
    }

    @Test
    public void testPermMissingElem() {
        assertEquals(4, permMissingElem.solution(new int[]{2, 3, 1, 5}));
        assertEquals(1, permMissingElem.solution(IntStream.range(2, 100_001).toArray()));
    }
}
