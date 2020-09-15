package com.liang.algorithm.leetcode.dynamicprogramming;

import com.liang.algorithm.leetcode.Utils;

public class MatrixBlockSum {
    public static void main(String[] args) {
        // mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
        int[][] mat = {{1,2,3},{4,5,6}, {7,8,9}, {7,8,9}};
        int K = 1;
        Utils.printArr2(official(mat, K));
    }

    // 开一个记忆矩阵，记忆左上角所有元素的和
    // 再利用记忆矩阵算矩形内元素和
    public static int[][] official(int[][] mat, int K) {
        if (mat == null || mat.length == 0) {
            return null;
        }
        int m = mat.length, n = mat[0].length;

        // t
        int[][] t = new int[m][n];
        t[0][0] = mat[0][0];
        for (int i = 1; i < n; i ++) {
            t[0][i] = t[0][i - 1] + mat[0][i];
        }
        for (int i = 1; i < m; i ++) {
            t[i][0] = t[i - 1][0] + mat[i][0];
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                t[i][j] = t[i - 1][j] + t[i][j - 1] - t[i - 1][j - 1] + mat[i][j];
            }
        }

        // r
        int[][] r = new int[m][n];
        int i1, i2, j1, j2;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                i1 = i - K - 1;
                i2 = Math.min(i + K, m - 1);
                j1 = j - K - 1;
                j2 = Math.min(j + K, n - 1);
                if (i1 >= 0 && j1 >= 0) {
                    r[i][j] = t[i2][j2] - t[i2][j1] - t[i1][j2] + t[i1][j1];
                } else if (i1 >= 0) {
                    r[i][j] = t[i2][j2] - t[i1][j2];
                } else if (j1 >= 0){
                    r[i][j] = t[i2][j2] - t[i2][j1];
                } else {
                    r[i][j] = t[i2][j2];
                }
            }
        }
        return r;
    }

    // 转移方程：f[i][j] = f[i][j-1] + sum(mat[i-k][j+k]..mat[i+k][j+k]) - sum(mat[i-k][j-1-k]..mat[i+k][j-1-k])
    // 转移方程：f[i][j] = f[i-1][j] + sum(mat[i+k][j-k]..mat[i+k][j+k]) - sum(mat[i-1-k][j-k]..mat[i-1-k][j+k])
    public static int[][] matrixBlockSum(int[][] mat, int K) {
        if (mat == null || mat.length == 0) {
            return null;
        }
        int m = mat.length, n = mat[0].length;
        int[][] sums = new int[m][n];
        // cal sums[0][0]
        for (int i = 0; i <= K; i ++) {
            for (int j = 0; j <= K; j ++) {
                if (i < m && j < n) {
                    sums[0][0] += mat[i][j];
                }
            }
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (j == 0) {
                    sums[i][j] = sums[i-1][j]
                            + ((i + K) < m ? partSum(j-K, j+K, mat[i+K]) : 0)
                            - ((i -1 - K) >= 0 ? partSum(j-K, j+K, mat[i-1-K]) : 0);
                    continue;
                }
                sums[i][j] = sums[i][j-1]
                        + ((j + K) < n ? colSum(i-K, i+K, j+K, mat) : 0)
                        - ((j -1 - K) >= 0 ? colSum(i-K, i+K, j-1-K, mat) : 0);
            }
        }
        return sums;
    }

    private static int partSum(int start, int end, int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = start; i <= end; i ++) {
            if (i >= 0 && i < len) {
                sum += arr[i];
            }
        }
        return sum;
    }

    private static int colSum(int start, int end, int col, int[][] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = start; i <= end; i ++) {
            if (i >= 0 && i < len) {
                sum += arr[i][col];
            }
        }
        return sum;
    }
}
