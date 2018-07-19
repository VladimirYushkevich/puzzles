package companies.amazon;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Solution1Test {

    private Solution1 solution1;

    @Before
    public void setUp() {
        solution1 = new Solution1();
    }

    @Test
    public void test() {
        assertThat(solution1.solution(new int[]{2, 2, 2, 2, 1, 2, -1, 2, 1, 3}), is(8));
        assertThat(solution1.solution(new int[]{30, 20, 10}), is(2));
        assertThat(solution1.solution(new int[]{2147483647, -2147483648}), is(1));
        assertThat(solution1.solution(new int[]{2147483647, -2147483648, 1}), is(1));
    }
}
