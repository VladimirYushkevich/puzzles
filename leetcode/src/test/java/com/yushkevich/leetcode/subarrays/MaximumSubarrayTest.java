package com.yushkevich.leetcode.subarrays;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaximumSubarrayTest {

    private MaximumSubarray testee = new MaximumSubarray();

    @Test
    public void maxSubArray() {
        assertThat(testee.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), is(6));
        assertThat(testee.maxSubArray(new int[]{1, 2}), is(3));
    }
}
