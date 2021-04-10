package companies.zalando;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Solution3Test {

    private Solution3 solution = new Solution3();

    @Test
    public void testSolution1() {
        assertThat(solution.solution(new int[]{1, 1, 3, 3, 3, 4, 5, 5, 5, 5}, 2), is(5));
    }

    @Test
    public void testSolution2() {
        assertThat(solution.solution(new int[]{1, 1, 2}, 1), is(3));
    }

    @Test
    public void testSolution3() {
        assertThat(solution.solution(new int[]{2}, 5), is(1));
    }

    @Test
    public void testSolution4() {
        assertThat(solution.solution(new int[]{1, 1, 8, 9}, 2), is(2));
        assertThat(solution.solution(new int[]{1, 8, 9}, 2), is(1));
        assertThat(solution.solution(new int[]{1, 8, 9}, 20), is(1));
    }
}
