package com.liang.algorithm.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(official(nums));
    }

    // 状态转移项：以i结尾的最大子数组和f(i)
    // f(i) = max(f(i - 1) + a(i), a(i))
    public static int official(int[] nums) {
        int f = 0, max = 0;
        for (int i = 0, len = nums.length; i < len; i ++) {
            if (i == 0) {
                f = nums[0];
                max = f;
            } else {
                f = Math.max(f + nums[i], nums[i]);
                max = Math.max(f, max);
            }
        }
        return max;
    }

    public int my1(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums不能为空");
        }
        int maxSubSum = nums[0];
        int maxSubEndIndex = 0;
        for (int i = 1, len = nums.length; i < len; i ++) {
            int tempSum = nums[i];
            int temMax = nums[i];
            int tempIndex = i;
            for (int j = i - 1; j > maxSubEndIndex; j --) {
                tempSum += nums[j];
                if (temMax < tempSum) {
                    temMax = tempSum;
                    tempIndex = j;
                }
            }

        }





        return -1;
    }


}
