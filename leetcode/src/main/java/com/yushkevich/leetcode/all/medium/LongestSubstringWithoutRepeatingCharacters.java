package com.yushkevich.leetcode.all.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> uniqueChars = new HashMap<>();
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            startIndex = Math.max(uniqueChars.getOrDefault(currentChar, -1) + 1, startIndex);
            uniqueChars.put(currentChar, i);
            maxLength = Math.max(i - startIndex + 1, maxLength);
        }
        return maxLength;
    }
}
