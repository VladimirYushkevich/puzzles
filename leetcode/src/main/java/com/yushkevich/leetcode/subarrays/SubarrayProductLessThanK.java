package com.yushkevich.leetcode.subarrays;

public class SubarrayProductLessThanK {

    /**
     * Input: nums = [10, 5, 2, 6], k = 100
     * Output: 8
     * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
     * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return effective(nums, k);
    }

    private int effective(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int prod = 1, res = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }

    private int quadratic(int[] nums, int k) {
        int length = nums.length;

        int res = 0;
        for (int slice = 1; slice <= length; slice++) {
            for (int start = 0; start <= length - slice; start++) {
                int product = 1;
                for (int i = start; i < start + slice; i++) {
                    int value = nums[i];

                    if (value == 0) {
                        res++;
                        break;
                    }

                    product *= value;
                    if (product >= k) {
                        break;
                    }

                    if (i == start + slice - 1) {
                        res++;
                    }

                }
            }
        }
        return res;
    }
}
