package freetests.lesson5;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountDivTest {

    private CountDiv countDiv;

    @Before
    public void setUp() {
        countDiv = new CountDiv();
    }

    @Test
    public void testCountDiv() {
        assertEquals(3, countDiv.solution(6, 11, 2));
        assertEquals(4, countDiv.solution(6, 12, 2));
        assertEquals(1, countDiv.solution(0, 5, 7));
        assertEquals(0, countDiv.solution(1, 5, 7));
        assertEquals(1, countDiv.solution(1, 5, 4));
        assertEquals(1, countDiv.solution(1, 5, 5));
        assertEquals(2000000000, countDiv.solution(1, 2000000000, 1));
        assertEquals(2, countDiv.solution(0, 2000000000, 2000000000));
        assertEquals(2, countDiv.solution(11, 14, 2));
        assertEquals(20, countDiv.solution(11, 345, 17));
    }
}
