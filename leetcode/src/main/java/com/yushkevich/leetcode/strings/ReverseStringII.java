package com.yushkevich.leetcode.strings;

public class ReverseStringII {

    static String reverseStr(String s, int k) {
        int startIndex = 0;
        final int length = s.length();
        StringBuilder res = new StringBuilder(length);
        while (startIndex < length) {
            final int endIndex = Math.min(2 * k + startIndex, length);
            String part = s.substring(startIndex, endIndex);
            int partLength = endIndex - startIndex;
            if (partLength >= k) {
                StringBuilder firstPart = new StringBuilder(part.substring(0, k));
                String secondPart = part.substring(k);
                res.append(firstPart.reverse());
                res.append(secondPart);
            } else {
                res.append(new StringBuilder(part).reverse());
            }
            startIndex = startIndex + 2 * k;
        }
        return res.toString();
    }
}
