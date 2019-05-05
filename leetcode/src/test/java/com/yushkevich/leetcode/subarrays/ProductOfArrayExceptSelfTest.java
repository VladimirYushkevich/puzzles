package com.yushkevich.leetcode.subarrays;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

public class ProductOfArrayExceptSelfTest {

    private ProductOfArrayExceptSelf testee;

    @Before
    public void setUp() {
        testee = new ProductOfArrayExceptSelf();
    }

    @Test
    public void productExceptSelf() {
        assertArrayEquals(Stream.of(24, 12, 8, 6).mapToInt(Integer::intValue).toArray(), testee.productExceptSelf(new int[]{1, 2, 3, 4}));
        assertArrayEquals(Stream.of(8, 4, 4, 4).mapToInt(Integer::intValue).toArray(), testee.productExceptSelf(new int[]{1, 2, 2, 2}));
        assertArrayEquals(Stream.of(16, 8, 8, 8, 8).mapToInt(Integer::intValue).toArray(), testee.productExceptSelf(new int[]{1, 2, 2, 2, 2}));
        assertArrayEquals(Stream.of(32, 16, 16, 16, 16, 16).mapToInt(Integer::intValue).toArray(), testee.productExceptSelf(new int[]{1, 2, 2, 2, 2, 2}));
        assertArrayEquals(Stream.of(64, 32, 32, 32, 32, 32, 32).mapToInt(Integer::intValue).toArray(), testee.productExceptSelf(new int[]{1, 2, 2, 2, 2, 2, 2}));
        assertArrayEquals(Stream.of(128, 64, 64, 64, 64, 64, 64, 64).mapToInt(Integer::intValue).toArray(), testee.productExceptSelf(new int[]{1, 2, 2, 2, 2, 2, 2, 2}));
        assertArrayEquals(Stream.of(720, 360, 240, 180, 144, 120).mapToInt(Integer::intValue).toArray(), testee.productExceptSelf(new int[]{1, 2, 3, 4, 5, 6}));
        assertArrayEquals(Stream.of(120, 60, 40, 30, 24).mapToInt(Integer::intValue).toArray(), testee.productExceptSelf(new int[]{1, 2, 3, 4, 5}));
    }
}
