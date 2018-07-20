package freetests.lesson6;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberOfDiscIntersectionsTest {

    private NumberOfDiscIntersections numberOfDiscIntersections;

    @Before
    public void setUp() {
        numberOfDiscIntersections = new NumberOfDiscIntersections();
    }

    @Test
    public void testNumberOfDiscIntersections() {
        assertThat(numberOfDiscIntersections.solution(new int[]{1, 5, 2, 1, 4, 0}), is(11));
//        assertThat(numberOfDiscIntersections.solution(new int[]{1, 2147483647, 0}), is(2));
    }
}
