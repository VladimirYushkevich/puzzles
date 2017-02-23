package freetests.lesson4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermCheckTest {

    private PermCheck permCheck;

    @Before
    public void setUp() {
        permCheck = new PermCheck();
    }

    @Test
    public void testTapeEquilibrium() {
        assertEquals(1, permCheck.solution(new int[]{4, 1, 3, 2}));
        assertEquals(0, permCheck.solution(new int[]{4, 1, 3}));
        assertEquals(0, permCheck.solution(new int[]{4, 1, 3, 3}));
        assertEquals(0, permCheck.solution(new int[]{4}));
        assertEquals(1, permCheck.solution(new int[]{1}));
    }
}
