package com.yushkevich.leetcode.subarrays;

public class BestTimeToBuyAndSellStock {

    /*
    Input: [7,1,5,3,6,4]

    ASC(indexes):  [1,3,5,2,4,0]
    DESC(indexes): [0,4,2,5,3,1]

    Output: 5
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public int quadratic(int[] prices) {
        int length = prices.length;
        int profit = 0;
        int min = 0;
        for (int i = 0; i < length; i++) {
            int buyPrice = prices[i];
            int sellPrice = prices[i];

            if (min > 0 && buyPrice > min) {
                continue;
            }

            for (int j = i + 1; j < length; j++) {
                int price = prices[j];
                if (price > sellPrice) {
                    sellPrice = price;
                }
            }

            int currentProfit = sellPrice - buyPrice;
            if (currentProfit > profit) {
                profit = currentProfit;
                min = buyPrice;
            }


        }

        return profit;
    }
}
