package com.liang.algorithm.leetcode;

import javax.rmi.CORBA.Util;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *  
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * 通过次数338,431提交次数671,930
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DuplicateRemove {
    public static void main(String[] args) {
//        int[] nums = {1,1,2};
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Uitls.printArr(nums);
        Uitls.printArr(nums, my2(nums));
    }

    public static int my1(int[] nums) {
        // sol: 遍历加平移 time O(n^2)
        if (nums.length == 0) {
            return 0;
        }

        // 有效长度
        int l = 1;
        // 尾部无效部分，每平移一次，无效部分加1
        int invalid = 0;
        for (int i = 1, len = nums.length; i < len; i ++) {
            while (len - 1 - i - invalid > 0 && nums[i] == nums[i - 1]) {
                // 平移
                System.arraycopy(nums, i + 1, nums, i, len - 1 - i - invalid);
                invalid ++;
            }

            if (nums[i] > nums[i - 1]) {
                l ++;
            }
        }

        return l;
    }

    public static int my2(int[] nums) {
        // sol： 遍历 + 双指针，一个指向有效数字，一个指向最新数字
        // 与官方一样
        if (nums.length == 0) return 0;

        int l = 0;
        for (int i = 1, len = nums.length; i < len; i ++) {
            if (nums[i] > nums[l]) {
                l ++;
                if (l != i) { nums[l] = nums[i]; }
            }
        }

        return l + 1;
    }
}
