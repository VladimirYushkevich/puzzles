package com.yushkevich.leetcode.arrays;

import org.junit.Test;

import static com.yushkevich.leetcode.arrays.RottingOranges.orangesRotting;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RottingOrangesTest {

    @Test
    public void testOrangesRotting() {
        assertThat(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}), is(4));
        assertThat(orangesRotting(new int[][]{{1, 1, 1}, {2, 1, 0}, {0, 1, 1}}), is(3));
        assertThat(orangesRotting(new int[][]{{1, 1, 1}, {1, 1, 0}, {0, 1, 1}}), is(-1));
    }
}
