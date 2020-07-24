package com.liang.algorithm.leetcode;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MySqrt {
    public static void main(String[] args) {
//        System.out.println(my1(0));
//        System.out.println(my1(1));
//        System.out.println(my1(2));
//        System.out.println(my1(4));
//        System.out.println(my1(8));
//        System.out.println(my1(9));

//        System.out.println(my2(0));
//        System.out.println(my2(1));
//        System.out.println(my2(2));
//        System.out.println(my2(4));
//        System.out.println(my2(8));
//        System.out.println(my2(9));
//        System.out.println(my2(Integer.MAX_VALUE));

        System.out.println(my3(0));
        System.out.println(my3(1));
        System.out.println(my3(2));
        System.out.println(my3(4));
        System.out.println(my3(8));
        System.out.println(my3(9));
        System.out.println(my3(15));
        System.out.println(my3(16));
        System.out.println(my3(17));
        System.out.println(my3(Integer.MAX_VALUE));
    }

    // O(n)
    public static int my1(int x) {
        for (int i = 0; i <= x; i ++) {
            if (i * i == x) {
                return i;
            } else if(i * i > x) {
                return i - 1;
            }
        }

        return x;
    }

    // O(lgn) StackOverflow
    public static int my2(int x) {
        if (x == 0) {
            return 0;
        }
        final int f1 = my2(x - 1);
        if (x == (f1 + 1) * (f1 + 1)) {
            return f1 + 1;
        } else {
            return f1;
        }
    }

    // O(lgn) divide
    public static int my3(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }

        int start = 0, end = x;
        int sqrt = 0;
        while (start <= end) {
            sqrt = (start + end) / 2;
            if (sqrt == x / sqrt) {
                return sqrt;
            } else if (sqrt > x / sqrt) {
                end = sqrt - 1;
            } else {
                start = sqrt + 1;
            }
        }

        if (sqrt > x / sqrt) {
            return sqrt - 1;
        } else {
            return sqrt;
        }
    }
}
