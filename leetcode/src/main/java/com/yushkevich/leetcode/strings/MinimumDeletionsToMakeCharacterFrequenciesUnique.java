package com.yushkevich.leetcode.strings;

import java.util.*;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public static int minDeletions(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char bucket = chars[i];
            Integer frequency = counts.getOrDefault(bucket, 0) + 1;
            counts.put(bucket, frequency);
        }

        List<Integer> frequencies = new ArrayList<>(counts.values());
        Collections.sort(frequencies);

        Set<Integer> uniqueFrequencies = new HashSet<>();
        int res = 0;
        for (Integer frequency : frequencies) {
            if (!uniqueFrequencies.add(frequency)) {
                for (int i = frequency; i >= 0; i--) {
                    if (!uniqueFrequencies.contains(i)) {
                        res = res + frequency - i;
                        if (i > 0) {
                            uniqueFrequencies.add(i);
                        }
                        break;
                    }
                }
            }
        }

        return res;
    }
}
