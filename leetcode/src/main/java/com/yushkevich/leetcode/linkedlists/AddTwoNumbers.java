package com.yushkevich.leetcode.linkedlists;

public class AddTwoNumbers {

    /*
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum;
        ListNode head;
        ListNode current = new ListNode(0);
        head = current;
        while (l1 != null || l2 != null) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int value = current.val;
            value += sum;

            if (value >= 10) {
                current.val = value - 10;
                value = 1;
            } else {
                current.val = value;
                value = 0;
            }

            ListNode tail = (l1 == null && l2 == null && sum < 10 && value == 0) ? null : new ListNode(value);
            current.next = tail;
            current = tail;
        }

        return head;
    }

    public static class ListNode {
        int val;
        AddTwoNumbers.ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
