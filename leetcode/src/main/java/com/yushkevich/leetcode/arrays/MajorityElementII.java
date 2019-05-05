package com.yushkevich.leetcode.arrays;

import java.util.*;

public class MajorityElementII {

    /*
    Input: [3,2,3]
    Output: [3]
     */
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> res = new HashSet<>();
        int length = nums.length;
        int frequency = length / 3;
        if (frequency == 0) {
            for (int num : nums) {
                res.add(num);
            }
            return new ArrayList<>(res);
        }

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : nums) {
            Integer currentFrequency = frequencies.get(element);
            if (currentFrequency == null) {
                frequencies.put(element, 1);
            } else {
                currentFrequency++;
                if (currentFrequency > frequency) {
                    res.add(element);
                }
                frequencies.put(element, currentFrequency);
            }
        }

        return new ArrayList<>(res);
    }
}
