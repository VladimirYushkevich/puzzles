package com.yushkevich.leetcode.linkedlists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class AddTwoNumbersII {

    /*
    Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 8 -> 0 -> 7
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> values1 = new Stack<>();
        Stack<Integer> values2 = new Stack<>();

        while (l1 != null) {
            values1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            values2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!values1.empty() || !values2.empty()) {
            if (!values1.isEmpty()) {
                sum += values1.pop();
            }
            if (!values2.isEmpty()) {
                sum += values2.pop();
            }

            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;

        }

        return list.val == 0 ? list.next : list;
    }

    private ListNode initial(ListNode l1, ListNode l2) {
        LinkedList<Integer> values1 = new LinkedList<>();
        LinkedList<Integer> values2 = new LinkedList<>();

        while (l1 != null) {
            values1.addFirst(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            values2.addFirst(l2.val);
            l2 = l2.next;
        }

        LinkedList<Integer> longest = values1.size() >= values2.size() ? values1 : values2;
        LinkedList<Integer> shortest = values1.size() < values2.size() ? values1 : values2;
        final Iterator<Integer> longIt = longest.iterator();
        final Iterator<Integer> shortIt = shortest.iterator();
        int sum = 0;
        ListNode tail = null;
        ListNode head;
        while (longIt.hasNext()) {
            sum += longIt.next();
            if (shortIt.hasNext()) {
                sum += shortIt.next();
            }

            if (sum >= 10 && longIt.hasNext()) {
                sum -= 10;
                head = new ListNode(sum);
                sum = 1;
            } else if (sum >= 10) {
                sum -= 10;
                head = new ListNode(sum);
                head.next = tail;
                tail = new ListNode(1);
                tail.next = head;
                break;
            } else {
                head = new ListNode(sum);
                sum = 0;
            }

            head.next = tail;
            tail = head;
        }

        return tail;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
