package com.yushkevich.leetcode.strings;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class RotateString {

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.length() == 0) {
            return true;
        }

        int length = A.length();
        for (int rotation = 1; rotation < length; rotation++) {
            for (int j = 0; j < length; j++) {
                int index = j + rotation >= length ? j + rotation - length : j + rotation;
                if (A.charAt(index) != B.charAt(j)) {
                    break;
                }
                if (j == length - 1) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean nonEffective(String A, String B) {
        if (A.isEmpty() && B.isEmpty()) {
            return true;
        }

        LinkedList<Character> listA = A.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(LinkedList::new));
        for (int i = 0; i < listA.size(); i++) {
            Character head = listA.poll();
            listA.addLast(head);

            StringBuilder sb = new StringBuilder(listA.size());
            listA.forEach(c -> sb.append(c.charValue()));

            String res = sb.toString();
            if (res.equals(B)) {
                return true;
            }
        }
        return false;
    }
}
