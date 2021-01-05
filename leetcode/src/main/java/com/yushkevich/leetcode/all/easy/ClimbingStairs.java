package com.yushkevich.leetcode.all.easy;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int res = 0;
        for (int i = 0; i <= n; i = i + 2) {
            long fact = combinationFactorial(n - i / 2, n - i);
            res += fact;
        }
        return res;
    }

    public long combinationFactorial(int n, int k) {
        long ratio = 1;
        for (int i = k + 1; i <= n; i++) {
            ratio = ratio * i / (i - k);
        }
        return ratio;
    }
}
