package com.yushkevich.leetcode.subarrays;

import java.util.HashMap;

public class SubarraySumEqualsK {

    /*
    Input:nums = [1,1,1], k = 2
    Output: 2
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    private int quadratic(int[] nums, int k) {
        int length = nums.length;

        int res = 0;
        for (int start = 0; start < length; start++) {
            for (int end = start + 1; end <= length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
