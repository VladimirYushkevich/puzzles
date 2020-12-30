package com.yushkevich.leetcode.all.easy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ValidParenthesesTest {

    private final ValidParentheses solution = new ValidParentheses();

    @Test
    public void exampleOne() {
        assertThat(solution.isValid("()"), is(true));
    }

    @Test
    public void exampleTwo() {
        assertThat(solution.isValid("()[]{}"), is(true));
    }

    @Test
    public void exampleThree() {
        assertThat(solution.isValid("(]"), is(false));
    }

    @Test
    public void exampleFour() {
        assertThat(solution.isValid("]"), is(false));
    }
}
