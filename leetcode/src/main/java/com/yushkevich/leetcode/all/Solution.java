package com.yushkevich.leetcode.all;

public class Solution {

    //[3,2,2,3] 3 -> [2,2]
    //[0,1,2,2,3,0,4,2] 2 -> [0,1,3,0,4]
    public int removeElement(int[] nums, int val) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            if (left == val) {
                res++;
                for (int j = nums.length - i - 1; j > 0; j--) {
                    int right = nums[j];
                    if (j > i && right != val) {
                        nums[i] = right;
                        nums[j] = left;
                        break;
                    }
                    if (j > i && right == val) {
                        res++;
                    }
                }
            }
        }
        return res > 1 ? res - 1 : 0;
    }
}
