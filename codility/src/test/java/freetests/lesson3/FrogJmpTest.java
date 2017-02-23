package freetests.lesson3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrogJmpTest {

    private FrogJmp frogJmp;

    @Before
    public void setUp() {
        frogJmp = new FrogJmp();
    }

    @Test
    public void testFrogJmp() {
        assertEquals(3, frogJmp.solution(10, 85, 30));
        assertEquals(0, frogJmp.solution(10, 10, 30));
        assertEquals(1, frogJmp.solution(10, 40, 30));
        assertEquals(2, frogJmp.solution(10, 41, 30));
    }
}
