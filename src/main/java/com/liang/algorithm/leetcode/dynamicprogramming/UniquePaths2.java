package com.liang.algorithm.leetcode.dynamicprogramming;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 */
public class UniquePaths2 {
    public static void main(String[] args) {
      int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
      System.out.println(my1(obstacleGrid));
    }

    // 动态规划：f(m x n) = f(m-1 x n) + f(m x n-1)
    private static int my1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i ++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i ++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            paths[0][i] = 1;
        }

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

        return paths[m - 1][n - 1];
    }
}
