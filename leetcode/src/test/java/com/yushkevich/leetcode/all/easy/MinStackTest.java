package com.yushkevich.leetcode.all.easy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MinStackTest {

    private MinStack solution = new MinStack();

    @Test
    public void exampleOne() {
        solution.push(-2);
        solution.push(-0);
        solution.push(-3);
        assertThat(solution.getMin(), is(-3));

        solution.pop();
        assertThat(solution.top(), is(0));

        assertThat(solution.getMin(), is(-2));
    }
}
