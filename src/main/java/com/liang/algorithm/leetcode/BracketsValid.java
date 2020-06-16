package com.liang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BracketsValid {
    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

//        System.out.println(isValid(s1));
//        System.out.println(isValid(s2));
//        System.out.println(isValid(s3));
//        System.out.println(isValid(s4));
//        System.out.println(isValid(s5));

        System.out.println(offical(s1));
        System.out.println(offical(s2));
        System.out.println(offical(s3));
        System.out.println(offical(s4));
        System.out.println(offical(s5));

    }

    public static boolean isValid(String s) {
        // 思路：使用栈，遍历并与栈顶比较，配对则出栈，否则入栈
        // time: O(n)
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0, len = s.length(); i < len; i ++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char c2 = stack.peek();
                if ((c2 == '(' && c == ')') ||
                        (c2 == '{' && c == '}') ||
                        (c2 == '[' && c == ']')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean offical(String s) {
        // 思路：开括号入栈，闭括号与栈顶元素比较，配对则出栈，否则无效
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0, len = s.length(); i < len; i ++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


}
