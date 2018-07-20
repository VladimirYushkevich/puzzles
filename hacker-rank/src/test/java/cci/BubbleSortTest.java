package cci;

import org.junit.Test;

import static cci.BubbleSort.solution;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {

    @Test
    public void bubbleSortTest() {
        assertThat(solution(new int[]{6, 4, 1}), is(new int[]{3, 1, 6}));
        assertThat(solution(new int[]{1, 2, 3}), is(new int[]{0, 1, 3}));
        assertThat(solution(new int[]{3, 2, 1}), is(new int[]{3, 1, 3}));
    }
}
