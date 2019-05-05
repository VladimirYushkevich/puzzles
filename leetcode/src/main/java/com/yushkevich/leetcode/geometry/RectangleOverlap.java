package com.yushkevich.leetcode.geometry;

public class RectangleOverlap {

    /*
    Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
    Output: true
              ______________(3,3)
              |            |
         _____|____(2,2)   |
         |    |   |        |
         |    |(1,1)_______|
    (0,0)|________|

    Solution is to find a condition when they DON'T overlap
     */
    public boolean isRectangleOverlap(long[] rec1, long[] rec2) {
        boolean noOverlap = rec1[0] >= rec2[2] ||
                rec2[0] >= rec1[2] ||
                rec1[1] >= rec2[3] ||
                rec2[1] >= rec1[3];

        return !noOverlap;
    }
}
