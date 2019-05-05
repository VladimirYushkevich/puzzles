package com.yushkevich.leetcode.strings;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class RotateStringTest {

    private RotateString testee = new RotateString();

    @Test
    public void rotateString() {
        assertTrue(testee.rotateString("abcde", "cdeab"));
        assertFalse(testee.rotateString("abcde", "abced"));
    }
}
