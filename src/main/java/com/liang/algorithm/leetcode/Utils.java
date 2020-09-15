package com.liang.algorithm.leetcode;

import java.util.List;

public class Utils {
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
                System.out.print(nums[i] + ",");
            }
        }
    }

    public static void printArr2(int[][] nums) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        for (int[] arr : nums) {
            printArr(arr);
            System.out.println();
        }

    }

    public static void printList(List<Integer> list) {
        System.out.println();

        for (int i = 0, len = list.size(); i < len; i ++) {
            if (i == len - 1) {
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + ",");
            }
        }
    }
}
