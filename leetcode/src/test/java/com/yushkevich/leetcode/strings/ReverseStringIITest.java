package com.yushkevich.leetcode.strings;

import org.junit.Test;

import static com.yushkevich.leetcode.strings.ReverseStringII.reverseStr;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReverseStringIITest {

    @Test
    public void testReverseStr() {
        assertThat(reverseStr("abcdefg", 2), is("bacdfeg"));
    }
}
