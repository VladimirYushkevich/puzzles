package com.yushkevich.leetcode.subarrays;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BestTimeToBuyAndSellStockTest {

    private BestTimeToBuyAndSellStock testee = new BestTimeToBuyAndSellStock();

    @Test
    public void maxProfit() {
        assertThat(testee.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), is(5));
    }
}
