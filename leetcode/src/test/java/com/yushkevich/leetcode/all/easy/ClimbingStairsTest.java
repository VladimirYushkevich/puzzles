package com.yushkevich.leetcode.all.easy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClimbingStairsTest {

    private ClimbingStairs solution = new ClimbingStairs();

    @Test
    public void exampleOne() {
        assertThat(solution.climbStairs(2), is(2));
    }

    @Test
    public void exampleTwo() {
        assertThat(solution.climbStairs(3), is(3));
    }

    @Test
    public void exampleThree() {
        assertThat(solution.climbStairs(4), is(5));
    }

    @Test
    public void exampleFour() {
        assertThat(solution.climbStairs(5), is(8));
    }

    @Test
    public void exampleFive() {
        assertThat(solution.climbStairs(6), is(13));
    }

    @Test
    public void exampleSix() {
        assertThat(solution.climbStairs(35), is(14930352));
    }

    @Test
    public void exampleSeven() {
        assertThat(solution.climbStairs(44), is(1134903170));
    }
}
