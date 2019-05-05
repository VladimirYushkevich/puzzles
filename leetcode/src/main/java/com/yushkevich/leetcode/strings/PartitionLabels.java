package com.yushkevich.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    /*
        Input: S = "ababcbacadefegdehijhklij"
        Output: [9,7,8]
        Explanation:
        The partition is "ababcbaca", "defegde", "hijhklij".
         */
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> lastCharIndexes = new HashMap<>();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            final char key = S.charAt(i);
            lastCharIndexes.put(key, i);
        }

        List<Integer> res = new ArrayList<>();
        int lastValue = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            char value = S.charAt(i);
            int lastIndex = lastCharIndexes.get(value);
            max = Math.max(max, lastIndex);
            if (i == max) {
                res.add(i - lastValue + 1);
                lastValue = i + 1;
            }
        }

        return res;
    }

    public List<Integer> nonOptimal(String S) {
        Map<Character, Integer> lastCharIndexes = new HashMap<>();
        Map<Character, Integer> firstCharIndexes = new HashMap<>();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            final char key = S.charAt(i);
            lastCharIndexes.put(key, i);
            firstCharIndexes.putIfAbsent(key, i);
        }

        List<Integer> res = new ArrayList<>();
        int lastValue = 0;
        int max = 0;
        for (int i = 0; i < length; ) {
            char value = S.charAt(i);
            int lastIndex = lastCharIndexes.get(value);
            int firstNextIndex = i < length - 1 ? firstCharIndexes.get(S.charAt(i + 1)) : length - 1;
            if (lastIndex > max) {
                max = lastIndex;
            }
            if (lastIndex <= firstNextIndex && i >= max) {
                res.add(i - lastValue + 1);
                lastValue = i + 1;
            }
            i++;
        }

        return res;
    }
}
