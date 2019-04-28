package com.yushkevich.leetcode.subarray;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaximumProductSubarrayTest {

    private MaximumProductSubarray testee = new MaximumProductSubarray();

    @Test
    public void maxProduct() {
        assertThat(testee.maxProduct(new int[]{2, 3, -2, 4}), is(6));
        assertThat(testee.maxProduct(new int[]{-2, 0, -1}), is(0));
        assertThat(testee.maxProduct(new int[]{2, 3, -2, 4}), is(6));
        assertThat(testee.maxProduct(new int[]{-4, -3}), is(12));
        assertThat(testee.maxProduct(new int[]{-2, 3, -4}), is(24));
        assertThat(testee.maxProduct(new int[]{0, 2}), is(2));
        assertThat(testee.maxProduct(new int[]{2, 0}), is(2));
        assertThat(testee.maxProduct(new int[]{3, -1, 4}), is(4));
        assertThat(testee.maxProduct(new int[]{2, 3}), is(6));
        assertThat(testee.maxProduct(new int[]{2, -5, -2, -4, 3}), is(24));
    }
}
