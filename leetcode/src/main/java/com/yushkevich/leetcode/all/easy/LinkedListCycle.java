package com.yushkevich.leetcode.all.easy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> existingNodes = new HashSet<>();
        while (head != null) {
            if (existingNodes.contains(head)) {
                return true;
            } else {
                existingNodes.add(head);
                head = head.next;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
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
