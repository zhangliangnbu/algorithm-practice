package com.liang.algorithm.leetcode;

public class Uitls {
    public static void printArr(int[] nums) {
        printArr(nums, nums.length);
    }

    public static void printArr(int[] nums, int len) {
        System.out.println();

        if (len > nums.length) {
            System.out.print("长度输入有误");
            return;
        }

        for (int i = 0; i < len; i ++) {
            if (i == len - 1) {
                System.out.print(nums[i]);
            } else {
                System.out.print(nums[i] + "->");
            }
        }
    }
}
