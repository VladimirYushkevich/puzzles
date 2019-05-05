package com.yushkevich.leetcode.linkedlists;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddTwoNumbersTest {

    private AddTwoNumbers testee = new AddTwoNumbers();

    @Test
    public void addTwoNumbers() {
        AddTwoNumbers.ListNode a1 = new AddTwoNumbers.ListNode(2);
        AddTwoNumbers.ListNode a2 = new AddTwoNumbers.ListNode(4);
        a2.next = new AddTwoNumbers.ListNode(3);
        a1.next = a2;
        AddTwoNumbers.ListNode b1 = new AddTwoNumbers.ListNode(5);
        AddTwoNumbers.ListNode b2 = new AddTwoNumbers.ListNode(6);
        b2.next = new AddTwoNumbers.ListNode(4);
        b1.next = b2;
        AddTwoNumbers.ListNode res1 = testee.addTwoNumbers(a1, b1);
        assertThat(res1.val, is(7));
        assertThat(res1.next.val, is(0));
        assertThat(res1.next.next.val, is(8));
        assertThat(res1.next.next.next, nullValue());

        AddTwoNumbers.ListNode c1 = new AddTwoNumbers.ListNode(3);
        AddTwoNumbers.ListNode c2 = new AddTwoNumbers.ListNode(4);
        c2.next = new AddTwoNumbers.ListNode(3);
        c1.next = c2;
        AddTwoNumbers.ListNode d1 = new AddTwoNumbers.ListNode(5);
        AddTwoNumbers.ListNode d2 = new AddTwoNumbers.ListNode(2);
        d2.next = new AddTwoNumbers.ListNode(4);
        d1.next = d2;
        AddTwoNumbers.ListNode res2 = testee.addTwoNumbers(c1, d1);
        assertThat(res2.val, is(8));
        assertThat(res2.next.val, is(6));
        assertThat(res2.next.next.val, is(7));
        assertThat(res2.next.next.next, nullValue());

        AddTwoNumbers.ListNode f1 = new AddTwoNumbers.ListNode(3);
        f1.next = new AddTwoNumbers.ListNode(4);
        AddTwoNumbers.ListNode g1 = new AddTwoNumbers.ListNode(5);
        AddTwoNumbers.ListNode res3 = testee.addTwoNumbers(f1, g1);
        assertThat(res3.val, is(8));
        assertThat(res3.next.val, is(4));
        assertThat(res3.next.next, nullValue());

        AddTwoNumbers.ListNode h1 = new AddTwoNumbers.ListNode(0);
        AddTwoNumbers.ListNode j1 = new AddTwoNumbers.ListNode(0);
        AddTwoNumbers.ListNode res5 = testee.addTwoNumbers(h1, j1);
        assertThat(res5.val, is(0));
        assertThat(res5.next, nullValue());

        AddTwoNumbers.ListNode k1 = new AddTwoNumbers.ListNode(5);
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(5);
        AddTwoNumbers.ListNode res6 = testee.addTwoNumbers(k1, l1);
        assertThat(res6.val, is(0));
        assertThat(res6.next.val, is(1));
        assertThat(res6.next.next, nullValue());

        AddTwoNumbers.ListNode m1 = new AddTwoNumbers.ListNode(1);
        AddTwoNumbers.ListNode n1 = new AddTwoNumbers.ListNode(9);
        n1.next = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode res7 = testee.addTwoNumbers(m1, n1);
        assertThat(res7.val, is(0));
        assertThat(res7.next.val, is(0));
        assertThat(res7.next.next.val, is(1));
        assertThat(res7.next.next.next, nullValue());
    }
}
