package companies.zalando;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Solution1Test {

    private Solution1 solution = new Solution1();

    @Test
    public void testSolutionExample1() {
        assertThat(solution.solution(new int[]{1, -2, -3, 5}), is(1));
    }

    @Test
    public void testSolutionExample2() {
        assertThat(solution.solution(new int[]{1, 2, 3, -5}), is(-1));
    }

    @Test
    public void testSolutionExample3() {
        assertThat(solution.solution(new int[]{1, 2, 0, -5}), is(0));
    }
}
