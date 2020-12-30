package com.yushkevich.leetcode.all.easy;

import java.util.Objects;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return null;
        }

        ListNode current = new ListNode();
        ListNode res = null;
        while (l1 != null || l2 != null) {
            int first = l1 != null ? l1.val : Integer.MAX_VALUE;
            int second = l2 != null ? l2.val : Integer.MAX_VALUE;
            int min;
            ListNode newCurrent = new ListNode();
            if (first > second) {
                l2 = l2.next;
                min = second;
            } else {
                l1 = l1 != null ? l1.next : null;
                min = first;
            }
            if (res == null) {
                res = new ListNode(min, current);
            } else {
                current.val = min;
                if (l1 != null || l2 != null) {
                    current.next = newCurrent;
                    current = newCurrent;
                }
            }
        }
        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val &&
                    Objects.equals(next, listNode.next);
        }
    }
}
