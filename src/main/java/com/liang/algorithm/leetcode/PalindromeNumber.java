package com.liang.algorithm.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromeNumber {
    public static void main(String[] args) {
//        int x = 121;
//        int x = -121;
        int x = 10;
        System.out.println(x);
        System.out.println(offical(x));
    }

    public static boolean my1(int x) {
        // 思路：先进行反转，相等就是回文数，否则不是

        // 个位数都是
        if (x >= 0 && x < 10) return true;

        // 负数都不是
        if (x < 0) return false;

        // 反转
        int q = x, pop, rev = 0;
        while (q != 0) {
            pop = q % 10;
            q = q / 10;
            // 溢出直接返回false
            if(rev > (Integer.MAX_VALUE - pop) / 10) return false;
            rev = rev * 10 + pop;
        }

        return rev == x;
    }

    public static boolean offical(int x) {
        // 思路：反转一半，比较是否相等

        // 多位数的个位数为零都不是，因为零不能作为多位数的第一个数
        if (x % 10 == 0 && x != 0) return false;

        // 负数都不是
        if (x < 0) return false;

        // 反转
        // 两种情况：对称或不对称
        // 对称的话：最后x == rev, 不对称的话x刚好小于rev
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        // 对称或不对称
        return x == rev || x == rev / 10;

    }

}
