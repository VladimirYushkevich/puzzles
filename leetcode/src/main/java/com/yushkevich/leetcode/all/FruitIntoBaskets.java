package com.yushkevich.leetcode.all;

public class FruitIntoBaskets {

    public int totalFruit(int[] tree) {
        int res = 0;

        for (int i = 0; i < tree.length; i++) {
            int count = 0;

            int startIndex = i;

            int firstBucket = tree[startIndex];
            int secondBucket = -1;
            int endIndex = tree.length - 1;

            while (startIndex <= endIndex) {
                int current = tree[startIndex];

                if (current != firstBucket && secondBucket < 0) {
                    secondBucket = current;
                }

                if (current != firstBucket && current != secondBucket) {
                    break;
                }

                count++;
                startIndex++;
            }

            if (count > res) {
                res = count;
            }

            if (startIndex == endIndex + 1) {
                break;
            }
        }

        return res;
    }
}
