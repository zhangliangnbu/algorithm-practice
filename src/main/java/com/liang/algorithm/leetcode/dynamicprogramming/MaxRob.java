package com.liang.algorithm.leetcode.dynamicprogramming;

public class MaxRob {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(my1(nums));
    }

    // 状态转移方程：n间房的最大值f(n) = max(f(n-1), f(n-2) + an)
    private static int my1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int fn = 0, fn1, fn2;
        // i == 1
        fn = Math.max(nums[0], nums[1]);
        fn1 = fn;
        fn2 = nums[0];
        for (int i = 2; i < len; i ++) {
            fn = Math.max(fn1, fn2 + nums[i]);
            // 下次循环
            fn2 = fn1;
            fn1 = fn;
        }


        return fn;
    }
}
