package com.liang.algorithm.leetcode.dynamicprogramming;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(my3(1, 1));
        System.out.println(my3(3, 2));
        System.out.println(my3(7, 3));
    }

    // 递归：f(m x n) = f(m-1 x n) + f(m x n-1)
    // 超出时间限制
    public static int my1(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return my1(m - 1, n) + my1(m, n - 1);
    }

    // 动态规划：f(m x n) = f(m-1 x n) + f(m x n-1)
    public static int my2(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i ++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i ++) {
            paths[0][i] = 1;
        }

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m - 1][n - 1];
    }

    // 数学方法：总步数 = 规定的向下步数 + 规定的向右步数
    // 使用排列组合：总步数 = m + n - 2, 向下的步数 = m - 1, 向右的步数 = n - 1
    // 从m + n - 2中选出有多少种向下步数的组合？C(m + n -2)^(m - 1)
    public static int my3(int m, int n) {
        return factorial(m + n - 2) / (factorial(m - 1) * factorial(n - 1));
    }

    private static int factorial(int x) {
        int f = 1;
        for (int i = 1; i <= x; i ++) {
            f *= i;
        }
        return f;
    }
}
