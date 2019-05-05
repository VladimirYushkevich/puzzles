package com.yushkevich.leetcode.linkedlists;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddTwoNumbersIITest {

    private AddTwoNumbersII testee = new AddTwoNumbersII();

    @Test
    public void addTwoNumbers() {
        final AddTwoNumbersII.ListNode a1 = new AddTwoNumbersII.ListNode(5);
        final AddTwoNumbersII.ListNode b1 = new AddTwoNumbersII.ListNode(6);
        AddTwoNumbersII.ListNode res1 = testee.addTwoNumbers(a1, b1);
        assertThat(res1.val, is(1));
        assertThat(res1.next.val, is(1));

        AddTwoNumbersII.ListNode c1 = new AddTwoNumbersII.ListNode(7);
        AddTwoNumbersII.ListNode c2 = new AddTwoNumbersII.ListNode(2);
        AddTwoNumbersII.ListNode c3 = new AddTwoNumbersII.ListNode(4);
        c3.next = new AddTwoNumbersII.ListNode(3);
        c2.next = c3;
        c1.next = c2;
        AddTwoNumbersII.ListNode d1 = new AddTwoNumbersII.ListNode(5);
        AddTwoNumbersII.ListNode d2 = new AddTwoNumbersII.ListNode(6);
        d2.next = new AddTwoNumbersII.ListNode(4);
        d1.next = d2;
        AddTwoNumbersII.ListNode res2 = testee.addTwoNumbers(c1, d1);
        assertThat(res2.val, is(7));
        assertThat(res2.next.val, is(8));
        assertThat(res2.next.next.val, is(0));
        assertThat(res2.next.next.next.val, is(7));

        final AddTwoNumbersII.ListNode e1 = new AddTwoNumbersII.ListNode(5);
        final AddTwoNumbersII.ListNode f1 = new AddTwoNumbersII.ListNode(5);
        AddTwoNumbersII.ListNode res3 = testee.addTwoNumbers(e1, f1);
        assertThat(res3.val, is(1));
        assertThat(res3.next.val, is(0));

        final AddTwoNumbersII.ListNode g1 = new AddTwoNumbersII.ListNode(1);
        final AddTwoNumbersII.ListNode h1 = new AddTwoNumbersII.ListNode(9);
        h1.next = new AddTwoNumbersII.ListNode(9);
        AddTwoNumbersII.ListNode res4 = testee.addTwoNumbers(g1, h1);
        assertThat(res4.val, is(1));
        assertThat(res4.next.val, is(0));
        assertThat(res4.next.next.val, is(0));
    }
}
