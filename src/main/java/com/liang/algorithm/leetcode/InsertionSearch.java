package com.liang.algorithm.leetcode;

/**
 * 定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertionSearch {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(my1(nums, 5) == 2);
        System.out.println(my1(nums, 2) == 1);
        System.out.println(my1(nums, 7) == 4);
        System.out.println(my1(nums, 0) == 0);

        System.out.println(offical(nums, 5) == 2);
        System.out.println(offical(nums, 2) == 1);
        System.out.println(offical(nums, 7) == 4);
        System.out.println(offical(nums, 0) == 0);
    }

    public static int my1(int[] nums, int target) {
        // sol: 二分查找, time O(lgn)

        // 特殊情况
        if (nums == null) {
            return 0;
        }
        if (nums.length == 0) {
            return 0;
        }

        // 边界判断
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }

        // 一般情况
        int start = 0, end = nums.length - 1;
        while (start < end - 1) {
            final int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static int offical(int[] nums, int target) {
        // sol : 思路一样，简化
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 不用 （left + right）/2 避免溢出
            final int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }






















}
