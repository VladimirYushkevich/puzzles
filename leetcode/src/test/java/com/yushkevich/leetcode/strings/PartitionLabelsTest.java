package com.yushkevich.leetcode.strings;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class PartitionLabelsTest {

    private PartitionLabels testee = new PartitionLabels();

    @Test
    public void partitionLabels() {
        assertArrayEquals(Arrays.asList(9,7,8).toArray(), testee.partitionLabels("ababcbacadefegdehijhklij").toArray());
        assertArrayEquals(Arrays.asList(11,7,8).toArray(), testee.partitionLabels("ababcbacabcdefegdehijhklij").toArray());
        assertArrayEquals(Arrays.asList(10,7,8).toArray(), testee.partitionLabels("ababcbacacdefegdehijhklij").toArray());
    }
}
