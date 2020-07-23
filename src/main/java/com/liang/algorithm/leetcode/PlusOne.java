package com.liang.algorithm.leetcode;

/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public static void main(String[] args) {
//        int[] digits = {1,2,3};
        int[] digits = {4,3,9,9};
//        int[] digits = {9,9,9};
        Uitls.printArr(my1(digits));
    }

    public static int[] my1(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i --) {
            int  current = digits[i] + carry;
            if (current < 10) {
                carry = 0;
            } else {
                carry = 1;
                current = current - 10;
            }
            digits[i] = current;

            if (carry == 0) {
                return digits;
            }

            if (i == 0) {
                int[] result = new int[digits.length + 1];
                System.arraycopy(digits, 0, result, 1, digits.length);
                result[0] = carry;
                return result;
            }
        }
        return digits;
    }
}
