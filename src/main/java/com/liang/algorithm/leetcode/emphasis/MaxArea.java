package com.liang.algorithm.leetcode.emphasis;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(my2(arr));
    }


    /**
     * 动态规划 ： 第i条线及其之前的最大值 = max(第k条线结束的最大值， k <= i)
     */
    private static int my1(int[] height) {
        if (height == null || height.length < 1) {
            return -1;
        }

        int[] maxs = new int[height.length];
        maxs[0] = 0;
        maxs[1] = Math.min(height[0], height[1]);
        for (int i = 2, len = height.length; i < len; i ++) {
            // 以i线结束的最大容量
            int iEndMax = 0, temp = 0;
            for (int j = 0; j < i; j ++) {
                temp = Math.min(height[j], height[i]) * (i - j);
                iEndMax = Math.max(iEndMax, temp);
            }
            // i线之前的最大容量
            maxs[i] = Math.max(maxs[i - 1], iEndMax);
        }

        return maxs[maxs.length - 1];
    }

    /**
     * 双指针
     */
    private static int my2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r]) {
                l ++;
            } else {
                r --;
            }
        }
        return maxArea;
    }
}
