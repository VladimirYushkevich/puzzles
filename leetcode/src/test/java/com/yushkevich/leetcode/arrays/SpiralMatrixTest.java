package com.yushkevich.leetcode.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.yushkevich.leetcode.arrays.SpiralMatrix.spiralOrder;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpiralMatrixTest {

    @Test
    public void testSpiralMatrix() {
        assertThat(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}), is(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)));
        assertThat(spiralOrder(new int[][]{}), is(new ArrayList<>()));
    }
}
