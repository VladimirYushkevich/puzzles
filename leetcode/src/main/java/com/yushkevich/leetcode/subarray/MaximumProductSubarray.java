package com.yushkevich.leetcode.subarray;

public class MaximumProductSubarray {

    /*
      Input: [2,3,-2,4]
      Output: 6
      Explanation: [2,3] has the largest product 6.
     */
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int res = nums[0];

        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int value = nums[i];

            int temp = maxProduct;
            maxProduct = Math.max(Math.max(maxProduct * value, minProduct * value), value);
            minProduct = Math.min(Math.min(temp * value, minProduct * value), value);

            if (maxProduct > res) {
                res = maxProduct;
            }
        }

        return res;
    }

}
