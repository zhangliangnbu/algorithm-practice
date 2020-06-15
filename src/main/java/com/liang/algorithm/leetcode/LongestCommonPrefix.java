package com.liang.algorithm.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"a"};
        String[] strs = {"dog","racecar","car"};
        System.out.println(offical(strs));

    }

    public static String my1(String[] strs) {
        // 通过二分查找的方法，定位最长公共前缀
        // 时间复杂度O(mn*log(n))\

        if (strs.length == 0) {
            return "";
        }

        // 最短字符串
        int shortestStrIndex = 0;
        for (int i = 0, len = strs.length; i < len; i ++) {
            if (strs[shortestStrIndex].length() > strs[i].length()) {
                shortestStrIndex = i;
            }
        }

        if (strs[shortestStrIndex].length() == 0) {
            return "";
        }

        // 插值法遍历
        int st = 0, en = strs[shortestStrIndex].length() - 1;
        int mid;
        while (st <= en) {
            mid = st + (en - st) / 2;
            if (allStartWith(strs, strs[shortestStrIndex].substring(0, mid + 1))) {
                st = mid + 1;
            } else {
                en = mid - 1;
            }

            // 没有公共子串
            if (en < 0) {
                return "";
            }

            if (st > en && st == mid + 1) {
                return strs[shortestStrIndex].substring(0, mid + 1);
            }

            if (en < st && en == mid - 1) {
                return strs[shortestStrIndex].substring(0, mid);
            }
        }
        return "";
    }

    private static String my2(String[] strs) {
        // 思路：逐个字符排除，复杂度O(mn)

        if (strs.length == 0) {
            return "";
        }

        // 最短字符串
        int shortestStrIndex = 0;
        for (int i = 0, len = strs.length; i < len; i ++) {
            if (strs[shortestStrIndex].length() > strs[i].length()) {
                shortestStrIndex = i;
            }
        }

        if (strs[shortestStrIndex].length() == 0) {
            return "";
        }

        // 遍历
        int index = -1;
        for (int i = 0, len = strs[shortestStrIndex].length(); i < len; i ++) {
            char c = strs[shortestStrIndex].charAt(i);
            if (!isContainChar(strs, c, i)) {
                break;
            }
            index = i;
        }
        if (index < 0) {
            return "";
        } else {
            return strs[shortestStrIndex].substring(0, index + 1);
        }
    }

    private static String offical(String[] strs) {
        // 思路：状态转移，第n个字符串的前缀，即为n-1之前与n的比较
        // time: O(mn)

        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];
        for (int i = 1, len = strs.length; i < len; i ++) {
            prefix = twoStrPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }

        return prefix;
    }

    private static String twoStrPrefix(String str1, String str2) {
//        int index = -1;
//        for (int i = 0, len = str1.length(); i < len; i ++) {
//            if (str2.length() <= i || str2.charAt(i) != str1.charAt(i)) {
//                break;
//            }
//            index = i;
//        }
//        if (index < 0) {
//            return "";
//        } else {
//           return str1.substring(0, index + 1);
//        }

        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);

    }

    private static boolean isContainChar(String[] strs, char c, int i) {
        for (String str : strs) {
            if (str.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }

    private static boolean allStartWith(String[] strs, String str) {
        for (String s : strs) {
            if (!s.startsWith(str)) {
                return false;
            }
        }
        return true;
    }

}
