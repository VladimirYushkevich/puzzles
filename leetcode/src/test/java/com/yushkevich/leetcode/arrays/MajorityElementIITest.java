package com.yushkevich.leetcode.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;

public class MajorityElementIITest {

    private MajorityElementII testee = new MajorityElementII();

    @Test
    public void majorityElement() {
        assertArrayEquals(Collections.singletonList(3).toArray(), testee.majorityElement(new int[]{3, 2, 3}).toArray());
        assertArrayEquals(Arrays.asList(1, 2).toArray(), testee.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}).toArray());
        assertArrayEquals(Collections.singletonList(1).toArray(), testee.majorityElement(new int[]{1}).toArray());
        assertArrayEquals(Arrays.asList(1, 2).toArray(), testee.majorityElement(new int[]{1, 2}).toArray());
        assertArrayEquals(Collections.singletonList(2).toArray(), testee.majorityElement(new int[]{2, 2}).toArray());
    }

}
