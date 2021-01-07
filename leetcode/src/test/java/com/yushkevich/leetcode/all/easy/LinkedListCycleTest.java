package com.yushkevich.leetcode.all.easy;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LinkedListCycleTest {

    private LinkedListCycle solution = new LinkedListCycle();

    @Test
    public void exampleOne() {
        LinkedListCycle.ListNode one = new LinkedListCycle.ListNode(3);
        LinkedListCycle.ListNode two = new LinkedListCycle.ListNode(2);
        LinkedListCycle.ListNode three = new LinkedListCycle.ListNode(0);
        LinkedListCycle.ListNode four = new LinkedListCycle.ListNode(-4);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

        assertTrue(solution.hasCycle(one));
    }
}
