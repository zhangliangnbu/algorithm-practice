package com.liang.algorithm.leetcode.dynamicprogramming;

/**
 * 1025. 除数博弈
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 *
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 *
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
 *
 *
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 *
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *
 *
 * 提示：
 *
 * 1 <= N <= 1000
 */
public class DivisorGame {
    public static void main(String[] args) {

    }


    /**
     * 定义 f[i]f[i] 表示当前数字 ii 的时候先手是处于必胜态还是必败态，\textit{true}true 表示先手必胜，\textit{false}false 表示先手必败，从前往后递推，根据我们上文的分析，枚举 ii 在 (0, i)(0,i) 中 ii 的因数 jj，看是否存在 f[i-j]f[i−j] 为必败态即可。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/divisor-game/solution/chu-shu-bo-yi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    // 动态规划：第n个数先手必胜或必败 = 从（0，n）中选出一个数符合条件的k，如果n-k先手必败，则n的先手必胜
    private static boolean my1(int N) {
        boolean[] f = new boolean[N + 5];
        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= N; i ++) {
            for (int k = 1; k < i; k ++) {
                if (i % k == 0 && !f[i - k]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[N];
    }
}
