package com.liang.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : zhangliang
 * @date : 2020/6/11
 *
 * 整数翻转：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerReverse {
    public static void main(String[] args) {
//        int x = Integer.MAX_VALUE; // 2147483647
//        int x = Integer.MIN_VALUE; // -2147483648
        int x = 120;
//        int x = -2147483412; // -2143
//        int x = -2147483648; // -2143
//        int x = 1563847412; // -2143
        System.out.println(x);
//        System.out.println(my1(x));
        System.out.println(my2(x));
        System.out.println(official(x));
    }

    public static int official(int x) {
        // 思路与使用队列一样，但不需要队列
        // 数学方法：通过循环整除10，得到余数，同时累加得到反转的数字（并与最大值比较，判断是否溢出）
        // 特殊情况：溢出
        // 时间复杂度O(n), 空间复杂度O(1)
        int pop, rev = 0;
        while (x != 0) {
            // 注意：负数除以整数得到的商和余数都是负数
            pop = x % 10;
            x = x / 10;

            // 溢出判断
            // 不能写 rev > (Integer.MAX_VALUE - pop) / 10 || rev < (Integer.MIN_VALUE - pop) / 10
            // 因为pop为正值则Integer.MIN_VALUE - pop 溢出，为负值则Integer.MAX_VALUE - pop溢出
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int my1(int x) {
        // 使用字符串：先转成字符串，然后字符串反转，遍历是否溢出
        // 特殊情况考虑：最小负数、负数、溢出
        // 时间复杂度O(n)，空间复杂度O(n)

        String s;
        if (x == Integer.MIN_VALUE) {
            // 最小负数没有对应的正值
            return 0;
        }

        if (x < 0) {
            // 负数
            s = String.valueOf(-x);
        } else {
            s  = String.valueOf(x);
        }

        // 无符号数字反转
        StringBuilder rs = new StringBuilder();
        for (int len = s.length(), i = len - 1; i >= 0; i --) {
            rs.append(s.charAt(i));
        }

        // 溢出
        String ms =  String.valueOf(Integer.MAX_VALUE);
        int rsi ,msi;
        if (rs.length() == ms.length()) {
            for (int i = 0, len = rs.length(); i < len; i ++) {
                rsi = rs.charAt(i);
                msi = ms.charAt(i);
                if (i == len - 1 && x < 0 && rsi > msi + 1) {
                    return 0;
                } else if (rsi > msi) {
                   return 0;
                } else if (rsi < msi) {
                    break;
                }
            }
        }

        String rss;
        if (x < 0) {
            rss = '-' + rs.toString();
        } else {
            rss = rs.toString();
        }
        return Integer.parseInt(rss);
    }

    public static int my2(int x) {
        // 使用队列：通过循环整除10将余数放入队列里，再逐一取出来（并与最大值比较，判断是否溢出）
        // 特殊情况：最下负数、负数、溢出
        // 时间复杂度O(n), 空间复杂度O(n)

        // 最小负数
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        // 负数
        boolean isNegative = x < 0;

        int q = Math.abs(x);
        int mod;
        Queue<Integer> queue = new LinkedList<Integer>();
        do {
            mod = q % 10;
            queue.add(mod);
            q = q / 10;
        } while (q != 0);

        int sum = 0, temp = 0, power = 1;
        while (!queue.isEmpty()) {
            temp = queue.remove();
            power = (int) Math.pow(10, queue.size());

            // 判断溢出
            if (temp > (Integer.MAX_VALUE - sum) / power) {
                return 0;
            }
            sum += temp * power;
        }
        return isNegative ? sum * (-1) : sum;
    }

    public static int my3(int x) {
        // 思路与使用队列一样，但不需要队列
        // 数学方法：通过循环整除10，得到余数，同时累加得到反转的数字（并与最大值比较，判断是否溢出）
        // 特殊情况：最小负数、负数、溢出
        // 时间复杂度O(n), 空间复杂度O(1)

        // 最小负数
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        // 负数
        boolean isNegative = x < 0;

        int q = Math.abs(x);
        int m, sum = 0;
        do {
            m = q % 10;

            // 溢出判断
            if (sum > (Integer.MAX_VALUE - m) / 10) {
                return 0;
            }
            sum = sum * 10 + m; // 这一步是重点，进位累加

            q = q / 10;
        } while (q != 0);

        return isNegative ? sum * (-1) : sum;
    }
}
