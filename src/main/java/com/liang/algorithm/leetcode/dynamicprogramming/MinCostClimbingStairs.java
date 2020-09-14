package com.liang.algorithm.leetcode.dynamicprogramming;

/**
 * 746. 使用最小花费爬楼梯
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 *
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 * 通过次数43,949提交次数88,483
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(my1(cost));
    }

    // 状态转移方程：以n结束的最小花费s(n) = min(s(n-1), s(n-2)) + cost(n)
    // n个台阶的最小花费f(n) = min(s(n), s(n-1))
    public static int my1(int[] cost) {
        if (cost == null || cost.length == 0 || cost.length == 1) {
            return 0;
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int first = cost[0], second = cost[1], temp;
        for (int i = 2, len = cost.length; i < len; i ++) {
            temp = second;
            second = Math.min(first, second) + cost[i];
            first = temp;
        }

        return Math.min(first, second);
    }
}
