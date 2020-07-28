package com.liang.algorithm.leetcode;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class MergeArrays {
    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        official(nums1, m, nums2, n);
        Uitls.printArr(nums1);
    }

    /**
     * 三指针，从尾部开始遍历
     */
    public static void official(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p1t = m + n - 1, p2 = n -1;
        while (p1t >= 0) {
            if (p1 < 0 || (p2 >= 0 && nums1[p1] < nums2[p2])) {
                nums1[p1t] = nums2[p2];
                p1t --;
                p2 --;
            } else if (p2 < 0 || nums1[p1] >= nums2[p2]) {
                nums1[p1t] = nums1[p1];
                p1t --;
                p1 --;
            }
        }
    }
}
