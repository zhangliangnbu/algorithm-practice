package com.liang.algorithm.leetcode.dynamicprogramming;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    // 转移方程 n之前的最大子数组和 = max(n-1之前的最大子数组和, 以n结尾的最大子数组和)
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSub = nums[0];
        int nEndMaxSub = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i ++) {
            nEndMaxSub = Math.max(nEndMaxSub + nums[i], nums[i]);
            maxSub = Math.max(maxSub, nEndMaxSub);
        }
        return maxSub;
    }
}
