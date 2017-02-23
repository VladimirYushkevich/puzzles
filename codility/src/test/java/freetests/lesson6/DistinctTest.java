package freetests.lesson6;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DistinctTest {

    private Distinct distinct;

    @Before
    public void setUp() {
        distinct = new Distinct();
    }

    @Test
    public void testDistinct() throws Exception {
        assertThat(distinct.solution(new int[]{}), is(0));
        assertThat(distinct.solution(new int[]{1, 2, 3}), is(3));
        assertThat(distinct.solution(new int[]{-1, -2, -3, -3, -2}), is(3));
        assertThat(distinct.solution(new int[]{9, 7, 8, 3, 2, 1}), is(6));
        assertThat(distinct.solution(new int[]{2, 1, 1, 2, 3, 1}), is(3));
    }
}
