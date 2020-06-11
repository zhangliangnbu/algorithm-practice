package com.liang.algorithm.leetcode;

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
//        int x = 120;
//        int x = -2147483412; // -2143
        int x = -2147483648; // -2143
        System.out.println(x);
        System.out.println(my1(x));
    }

    public static int my1(int x) {
        // 特殊情况考虑两点：负数、溢出

        String s;

        // 负数
        if (x < 0) {
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
}
