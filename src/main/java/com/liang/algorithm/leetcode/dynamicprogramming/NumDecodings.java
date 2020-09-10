package com.liang.algorithm.leetcode.dynamicprogramming;

public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(my1("10101"));
    }

    // 状态转移方程：f(前n个字符) = f(前n-1个字符) + f(前n-2个字符) * flag(0 / 1)
    private static int my1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        final int max = 26;
        int f = 0, fp = 1, fpp = 1;

        for (int i = 0, len = s.length(); i < len; i ++) {
            final int c = Character.digit(s.charAt(i), 10);
            if (i == 0 && c == 0) {
                return 0;
            }

            if (i == 0) {
                f = 1;
                continue;
            }

            fpp = fp;
            fp = f;
            final int cp = Character.digit(s.charAt(i - 1), 10);
            final int dc = cp * 10 + c;

            if (c == 0) {
                if (dc > 0 && dc < max) {
                    f = fpp;
                } else {
                    return 0;
                }
            } else if (cp == 0) {
                f = fp;
            } else if (cp * 10 + c <= max) {
                f = fp + fpp;
            } else {
                f = fp;
            }
        }

        return f;
    }
}
