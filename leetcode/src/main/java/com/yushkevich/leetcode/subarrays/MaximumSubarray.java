package com.yushkevich.leetcode.subarrays;

public class MaximumSubarray {

    /**
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];

            if (value > maxSum) {
                if (maxSum > 0) {
                    maxSum += value;
                } else {
                    maxSum = value;
                }
            } else {
                maxSum += value;
            }

            if (maxSum > res) {
                res = maxSum;
            }
        }

        return res;
    }
}
