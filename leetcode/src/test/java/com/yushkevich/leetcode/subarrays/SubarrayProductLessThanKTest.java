package com.yushkevich.leetcode.subarrays;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SubarrayProductLessThanKTest {

    private SubarrayProductLessThanK testee = new SubarrayProductLessThanK();

    @Test
    public void numSubarrayProductLessThanK() {
        assertThat(testee.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100), is(8));
    }
}
