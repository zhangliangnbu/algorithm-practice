package com.liang.algorithm.leetcode;

/**
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = " a";
        System.out.println(my1(s));
    }

    public static int my1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0, len = s.length(); i < len; i ++) {
            char c = s.charAt(len - 1 - i);
            if (c != ' ') {
                count ++;
            }
            if (count > 0 && (c == ' ' || i == len - 1)) {
                return count;
            }
        }
        return 0;
    }
}
