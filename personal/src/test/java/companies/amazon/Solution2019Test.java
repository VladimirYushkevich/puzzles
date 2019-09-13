package companies.amazon;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Solution2019Test {

    private Solution2019 solution2019;

    @Before
    public void setUp() {
        solution2019 = new Solution2019();
    }

    @Test
    public void testTestTask() {
        assertThat(solution2019.testTask(new int[]{1, 3, 6, 4, 1, 2}), is(5));
        assertThat(solution2019.testTask(new int[]{-1, -3}), is(1));
        assertThat(solution2019.testTask(new int[]{-1_000_000, 1_000_000}), is(1));
    }

    @Test
    public void testSolution1() {
        assertThat(solution2019.solution1(0), is(0));
        assertThat(solution2019.solution1(1), is(1));
        assertThat(solution2019.solution1(553), is(553));
        assertThat(solution2019.solution1(213), is(321));
        assertThat(solution2019.solution1(10_000), is(10_000));
        assertThat(solution2019.solution1(899), is(998));
        assertThat(solution2019.solution1(909), is(990));
    }


    @Test
    public void testSolution2() {
        assertThat(solution2019.solution2(955), is(4));
        assertThat(solution2019.solution2(1651), is(5));
        assertThat(solution2019.solution2(102), is(-1));
        assertThat(solution2019.solution2(1), is(-1));
        assertThat(solution2019.solution2(1_000_000_000), is(-1));
    }


    @Test
    public void testSolution3() {
        assertThat(solution2019.solution3(new int[]{3, 2, 4, 3}, 8, 4, 10), is(3));
        assertThat(solution2019.solution3(new int[]{2, 8, 4, 3, 2}, 7, 11, 3), is(8));
        assertThat(solution2019.solution3(new int[]{5}, 4, 0, 3), is(-1));
        assertThat(solution2019.solution3(new int[]{2, 8, 4, 3, 2}, 0, 11, 3), is(-1));
        assertThat(solution2019.solution3(new int[]{8, 4, 2}, 0, 11, 4), is(8));
        assertThat(solution2019.solution3(new int[]{2, 8, 4, 3, 2}, 0, 0, 0), is(-1));
        assertThat(solution2019.solution3(new int[]{2, 8, 4}, 2, 8, 3), is(-1));
    }
}
