package com.yushkevich.leetcode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    private Solution testee = new Solution();

    @Test
    public void removeElement() {
        assertThat(testee.removeElement(new int[]{3, 2, 2, 3}, 3), is(2));
    }
}
