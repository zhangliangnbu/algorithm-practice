package com.liang.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrStr {
    public static void main(String[] args) {
//        String haystack = "aaaaa";
//        String needle = "bba";
        String haystack = "hello";
        String needle = "ll";
        System.out.println(my2(haystack, needle));
    }

    public static int my1(String haystack, String needle) {
        // sol: 双指针，遍历，time O(nm)
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0, len = haystack.length() - needle.length(); i <= len; i ++) {
            int j = 0;
            while (needle.charAt(j) == haystack.charAt(i + j)) {
                if (j == needle.length() - 1) {
                    return i;
                }
                j ++;
            }
        }

        return -1;
    }

    public static int my2(String haystack, String needle) {
        // sol: hashset存储所有子串，hash查找，time O(n)
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>(haystack.length());
        for (int i = 0, len = haystack.length() - needle.length(); i <= len; i ++) {
            String sub = haystack.substring(i, i + needle.length());
            if (!map.containsKey(sub)) {
                map.put(sub, i);
            }
        }
        if (map.containsKey(needle)) {
            return map.get(needle);
        }

        return -1;
    }

    // 理解下
    public static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }
}
