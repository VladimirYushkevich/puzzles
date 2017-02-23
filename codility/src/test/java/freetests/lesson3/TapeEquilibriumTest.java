package freetests.lesson3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TapeEquilibriumTest {

    private TapeEquilibrium tapeEquilibrium;

    @Before
    public void setUp() {
        tapeEquilibrium = new TapeEquilibrium();
    }

    @Test
    public void testTapeEquilibrium() {
        assertEquals(1, tapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3}));
        assertEquals(2, tapeEquilibrium.solution(new int[]{3, 1}));
    }
}
