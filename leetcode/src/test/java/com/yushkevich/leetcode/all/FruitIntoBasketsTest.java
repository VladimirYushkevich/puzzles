package com.yushkevich.leetcode.all;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FruitIntoBasketsTest {

    private FruitIntoBaskets testee;

    @Before
    public void setUp() {
        testee = new FruitIntoBaskets();
    }

    @Test
    public void totalFruit() {
        assertThat(testee.totalFruit(new int[]{1, 2, 1}), is(3));
        assertThat(testee.totalFruit(new int[]{0, 1, 2, 2}), is(3));
        assertThat(testee.totalFruit(new int[]{1, 2, 3, 2, 2}), is(4));
        assertThat(testee.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}), is(5));
        assertThat(testee.totalFruit(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}), is(16));
    }
}
