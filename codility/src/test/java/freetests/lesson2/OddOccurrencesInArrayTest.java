package freetests.lesson2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OddOccurrencesInArrayTest {

    private OddOccurrencesInArray oddOccurrencesInArray;

    @Before
    public void setUp() {
        oddOccurrencesInArray = new OddOccurrencesInArray();
    }

    @Test
    public void testOddOccurrencesInArray() {
        assertEquals(7, oddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
        assertEquals(9, oddOccurrencesInArray.solution(new int[]{9}));
    }
}
