package com.yushkevich.leetcode.all.easy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class MergeTwoSortedListsTest {

    private final MergeTwoSortedLists solution = new MergeTwoSortedLists();

    @Test
    public void exampleOne() {
        MergeTwoSortedLists.ListNode l1 = new MergeTwoSortedLists.ListNode(1,
                new MergeTwoSortedLists.ListNode(2,
                        new MergeTwoSortedLists.ListNode(4)));
        MergeTwoSortedLists.ListNode l2 = new MergeTwoSortedLists.ListNode(1,
                new MergeTwoSortedLists.ListNode(3,
                        new MergeTwoSortedLists.ListNode(4)));
        assertThat(solution.mergeTwoLists(l1, l2), is(new MergeTwoSortedLists.ListNode(1,
                new MergeTwoSortedLists.ListNode(1,
                        new MergeTwoSortedLists.ListNode(2,
                                new MergeTwoSortedLists.ListNode(3,
                                        new MergeTwoSortedLists.ListNode(4,
                                                new MergeTwoSortedLists.ListNode(4))))))));
    }

    @Test
    public void exampleThree() {
        assertNull(solution.mergeTwoLists(null, null));
    }

    @Test
    public void exampleFour() {
        MergeTwoSortedLists.ListNode l2 = new MergeTwoSortedLists.ListNode(1);
        assertThat(solution.mergeTwoLists(null, l2), is(new MergeTwoSortedLists.ListNode(1)));
    }

    @Test
    public void exampleFive() {
        MergeTwoSortedLists.ListNode l1 = new MergeTwoSortedLists.ListNode(1,
                new MergeTwoSortedLists.ListNode(3,
                        new MergeTwoSortedLists.ListNode(5)));
        MergeTwoSortedLists.ListNode l2 = new MergeTwoSortedLists.ListNode(2,
                new MergeTwoSortedLists.ListNode(4,
                        new MergeTwoSortedLists.ListNode(6)));
        assertThat(solution.mergeTwoLists(l1, l2), is(new MergeTwoSortedLists.ListNode(1,
                new MergeTwoSortedLists.ListNode(2,
                        new MergeTwoSortedLists.ListNode(3,
                                new MergeTwoSortedLists.ListNode(4,
                                        new MergeTwoSortedLists.ListNode(5,
                                                new MergeTwoSortedLists.ListNode(6))))))));
    }

    @Test
    public void exampleSix() {
        MergeTwoSortedLists.ListNode l1 = new MergeTwoSortedLists.ListNode(-9,
                new MergeTwoSortedLists.ListNode(3));
        MergeTwoSortedLists.ListNode l2 = new MergeTwoSortedLists.ListNode(5,
                new MergeTwoSortedLists.ListNode(7));
        assertThat(solution.mergeTwoLists(l1, l2), is(new MergeTwoSortedLists.ListNode(-9,
                new MergeTwoSortedLists.ListNode(3,
                        new MergeTwoSortedLists.ListNode(5,
                                new MergeTwoSortedLists.ListNode(7))))));
    }
}
