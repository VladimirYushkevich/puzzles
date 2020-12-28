package com.yushkevich.leetcode.arrays;

import org.junit.Test;

import static com.yushkevich.leetcode.arrays.SpiralMatrixII.generateMatrix;
import static com.yushkevich.leetcode.arrays.SpiralMatrixII.solution;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class SpiralMatrixIITest {

    @Test
    public void testSpiralMatrixII() {
        assertThat(solution(3), is("[\n" +
                " [ 1, 2, 3 ],\n" +
                " [ 8, 9, 4 ],\n" +
                " [ 7, 6, 5 ]\n" +
                "]"));
        assertArrayEquals(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, generateMatrix(3));
    }
}
