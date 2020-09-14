package com.liang.algorithm.leetcode.dynamicprogramming;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc";
        System.out.println(my1(s, t));
    }

    // 针对s, 必须满足条件：第n个字符在t中存在一个索引大于第n-1个字符在t中的索引
    public static boolean my1(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }

        // s中前一个字符在t中的索引
        int first = -1;
        // s中后一个字符在t中的索引
        int second;
        for (int i = 0, len = s.length(); i < len; i ++) {
            // 从first + 1位置开始查找后一个字符在t中的第一个索引。
            // 为什么是第一个索引？为了后面的字符最大程度满足要求，可见官方的解释。
            second = t.indexOf(s.charAt(i), first + 1);
            // 找不到，说明s不是t的子序列
            if (second == -1) {
                return false;
            }
            // 找到了，进行下一次循环
            first = second;
        }

        // 都能找到，说明s是t的子序列
        return true;
    }

}
