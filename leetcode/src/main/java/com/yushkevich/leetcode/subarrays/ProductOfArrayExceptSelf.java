package com.yushkevich.leetcode.subarrays;

public class ProductOfArrayExceptSelf {

    /*
   Input:  [1,2,3,4]
   [1,2,6,24]
   [24,24,12,4]

   [1,2,6,24] left
   [24,24,12,4] right

   --- i=0 ----
   [1,0,0,4]
   --- i=1(merging, middle), res[i]=res[i-1]*right, left=2, right=12 ----
   [1,12,12,4]
   --- i=2(merging, middle), res[i]=left*res[i+1], left=2, right=24 ----
   [1,12,8,4]
   --- i=3(merging, right-left), res[i]=left, res[length - 1 - i]=right ----
   [24,12,8,6]

   Output: [24,12,8,6]

   [1, 2, 3, 4, 5, 6]

   [  1,   2,   6,  24, 120, 720] left
   [720, 720, 360, 120,  30, 6  ] right

   [  1,   0,   0,   0,   0, 6  ]
   [  1,   2,   0,   0,  30, 6  ]
   [  1,   2,   6, 120,  30, 6  ]
   ----- i=2 merging res[i] = res[i-1]*right, res[i-1]=2, left = 6, right = 120 -------
   [  1,   2, 240, 120,  30, 6  ]
   ----- i=3 merging res[i] = left*res[i+1], res[i+1]=30, left = 6 -------
   [  1,   2, 240, 180,  30, 6  ]
   ----- i=4 merging res[i] = left*res[i+1], left = 120, right = 720 -------
   [  1,   2, 240, 180, 144, 6  ]
   ----- i=5 merging res[i] = left, res[length - 1 - i] = right -------
   [720,   2, 240, 180, 144, 120]

   [720, 360, 240, 180, 144, 120]
    */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] res = new int[length];

        int right = 1;
        int left = 1;
        for (int i = 0; i < length; i++) {
            if (i > (length - 2) / 2) {
                int rightValue = i < length - 1 ? res[i + 1] : 1;
                int leftValue = i < length - 1 ? res[length - 2 - i] : 1;

                res[i] = left * rightValue;
                res[length - 1 - i] = leftValue * right;

                left = left * nums[i];
                right = right * nums[length - 1 - i];
            } else {
                left = left * nums[i];
                right = right * nums[length - 1 - i];

                res[i] = left;
                res[length - 1 - i] = right;
            }
        }

        return res;
    }
}
