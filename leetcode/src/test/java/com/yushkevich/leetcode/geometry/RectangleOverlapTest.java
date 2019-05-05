package com.yushkevich.leetcode.geometry;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class RectangleOverlapTest {

    private RectangleOverlap testee = new RectangleOverlap();

    @Test
    public void isRectangleOverlap() {
        assertTrue(testee.isRectangleOverlap(new long[]{0, 0, 2, 2}, new long[]{1, 1, 3, 3}));
        assertFalse(testee.isRectangleOverlap(new long[]{0, 0, 1, 1}, new long[]{1, 0, 2, 1}));
    }
}
