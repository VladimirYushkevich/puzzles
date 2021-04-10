package companies.nexthink;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Task2Test {

    private Task2 solution = new Task2();

    @Test
    public void testSolution() {
        assertThat(solution.solution(268), is(5268));
        assertThat(solution.solution(1), is(51));
        assertThat(solution.solution(6), is(65));
        assertThat(solution.solution(2683), is(52683));
        assertThat(solution.solution(670), is(6750));
        assertThat(solution.solution(0), is(50));
        assertThat(solution.solution(-999), is(-5999));
        assertThat(solution.solution(-1), is(-15));
    }
}
