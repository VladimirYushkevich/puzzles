package com.yushkevich.leetcode.linkedlists;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class MergeKSortedListsTest {

    @Test
    public void testMergeKLists() {
        MergeKSortedLists.ListNode[] lists = new MergeKSortedLists.ListNode[3];
        List.of(
                new MergeKSortedLists.ListNode(1, new MergeKSortedLists.ListNode(4, new MergeKSortedLists.ListNode(5))),
                new MergeKSortedLists.ListNode(1, new MergeKSortedLists.ListNode(3, new MergeKSortedLists.ListNode(4))),
                new MergeKSortedLists.ListNode(2, new MergeKSortedLists.ListNode(6))
        ).toArray(lists);
        assertThat(MergeKSortedLists.mergeKLists(lists), is(
                new MergeKSortedLists.ListNode(1, new MergeKSortedLists.ListNode(1, new MergeKSortedLists.ListNode(2,
                        new MergeKSortedLists.ListNode(3, new MergeKSortedLists.ListNode(4,
                                new MergeKSortedLists.ListNode(4, new MergeKSortedLists.ListNode(5,
                                        new MergeKSortedLists.ListNode(6))))))))));

    }

    @Test
    public void testMergeKListsExample1() {
        MergeKSortedLists.ListNode[] lists = new MergeKSortedLists.ListNode[2];
        List.of(
                new MergeKSortedLists.ListNode(1, new MergeKSortedLists.ListNode(2, new MergeKSortedLists.ListNode(2))),
                new MergeKSortedLists.ListNode(1, new MergeKSortedLists.ListNode(1, new MergeKSortedLists.ListNode(2)))
        ).toArray(lists);
        assertThat(MergeKSortedLists.mergeKLists(lists), is(
                new MergeKSortedLists.ListNode(1, new MergeKSortedLists.ListNode(1, new MergeKSortedLists.ListNode(1,
                        new MergeKSortedLists.ListNode(2, new MergeKSortedLists.ListNode(2,
                                new MergeKSortedLists.ListNode(2))))))));

    }

    @Test
    public void testEdgeCases() {
        assertNull(MergeKSortedLists.mergeKLists(null));
        assertNull(MergeKSortedLists.mergeKLists(new MergeKSortedLists.ListNode[1]));
    }
}
