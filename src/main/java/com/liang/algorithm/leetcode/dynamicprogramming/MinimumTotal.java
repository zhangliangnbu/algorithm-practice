package com.liang.algorithm.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        final List<Integer> r1 = new ArrayList<Integer>();
        r1.add(2);
        triangle.add(r1);

        final List<Integer> r2 = new ArrayList<Integer>();
        r2.add(3);
        r2.add(4);
        triangle.add(r2);

        final List<Integer> r3 = new ArrayList<Integer>();
        r3.add(6);
        r3.add(5);
        r3.add(7);
        triangle.add(r3);

        final List<Integer> r4 = new ArrayList<Integer>();
        r4.add(4);
        r4.add(1);
        r4.add(8);
        r4.add(3);
        triangle.add(r4);

        System.out.println(my2(triangle));
    }

    private static int my1(List<List<Integer>> triangle) {
        List<List<Integer>> total = new ArrayList<List<Integer>>();

        List<Integer> row0 = new ArrayList<Integer>();
        row0.add(triangle.get(0).get(0));
        total.add(row0);

        int row = triangle.size();
        for (int i = 1; i < row; i ++) {
            final List<Integer> currentTriangleRow = triangle.get(i);
            final List<Integer> lastTotalRow = total.get(i - 1);
            final List<Integer> currentTotalRow = new ArrayList<Integer>();
            for (int j = 0, col = currentTriangleRow.size(); j < col; j ++) {
                if (j == 0) {
                    currentTotalRow.add(lastTotalRow.get(j) + currentTriangleRow.get(j));
                } else if (j > 0 && j < col - 1) {
                    currentTotalRow.add(Math.min(lastTotalRow.get(j - 1), lastTotalRow.get(j)) + currentTriangleRow.get(j));
                } else {
                    currentTotalRow.add(lastTotalRow.get(lastTotalRow.size() - 1) + currentTriangleRow.get(j));
                }
            }
            total.add(currentTotalRow);
        }

        final List<Integer> lastTotalRow = total.get(total.size() - 1);
        int min = lastTotalRow.get(0);
        for (int i = 1, size = lastTotalRow.size(); i < size; i ++) {
            min = Math.min(lastTotalRow.get(i), min);
        }

        return min;
    }

    // 空间复杂度O(n)
    private static int my2(List<List<Integer>> triangle) {
        final int row = triangle.size();
        // 只需要存储一行有用的数值就可以了
        int[] total = new int[row];
        total[0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i ++) {
            for (int j = i; j >= 0; j --) {
                if (j == i) {
                    total[j] = total[j - 1] + triangle.get(i).get(j);
                } else if (j < i && j > 0){
                    total[j] = Math.min(total[j], total[j - 1]) + triangle.get(i).get(j);
                } else {
                    total[j] = total[j] + triangle.get(i).get(j);
                }
            }
        }

        int min = total[0];
        for (int i = 1; i < row; i ++) {
            min = Math.min(min, total[i]);
        }
        return min;
    }
}
