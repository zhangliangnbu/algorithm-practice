package com.liang.algorithm.leetcode.dynamicprogramming;

public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = { 7,1,5,3,6,4 };
        System.out.println(my1(prices));
    }

    // 第n天卖出的最大利润 = prices[n] - [0, n]天内最小的值
    // 前n天最小值 = min(前n-1最小值, prices[n])
    private static int my1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int minPrice = prices[0];
        int maxProfile = 0;
        for (int i = 1; i < len; i ++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfile = Math.max(maxProfile, prices[i] - minPrice);
        }
        return maxProfile;
    }

}
