package com.yushkevich.leetcode.all.easy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SingleNumberTest {

    SingleNumber solution = new SingleNumber();

    @Test
    public void exampleOne() {
        assertThat(solution.singleNumber(new int[]{2, 2, 1}), is(1));
    }
}
