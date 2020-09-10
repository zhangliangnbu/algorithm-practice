package com.liang.algorithm.leetcode.dynamicprogramming;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * <p>
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */
public class SumRange {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray na = new NumArray(nums);
        System.out.println(na.sumRange(0, 2));
        System.out.println(na.sumRange(2, 5));
        System.out.println(na.sumRange(0, 5));
    }

    public static class NumArray {

        private int[] nums;
        private int[] sums;

        public NumArray(int[] nums) {
            this.nums = nums;

            if (nums == null || nums.length == 0) {
                return;
            }
            this.sums = new int[nums.length];
            int len = nums.length;
            sums[0] = nums[0];
            for (int k = 1; k < len; k++) {
                sums[k] = sums[k - 1] + nums[k];
            }
        }

        // 用一维数组存储[0, n]的累加和
        public int sumRange(int i, int j) {
            if (sums == null || sums.length == 0) {
                return 0;
            }
            if (i >= sums.length || j >= sums.length) {
                return 0;
            }
            if (i > j) {
                return 0;
            }
            return sums[j] - sums[i] + nums[i];
        }
    }
}
