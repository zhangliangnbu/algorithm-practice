package com.liang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class LevelOrderBottom {

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(3);
        TreeNode n1l = new TreeNode(9);
        TreeNode n1r = new TreeNode(20);
        TreeNode n2l = new TreeNode(15);
        TreeNode n2r = new TreeNode(7);
        n0.left = n1l;
        n0.right = n1r;
        n1r.left = n2l;
        n1r.right = n2r;
        List<List<Integer>> lists = levelOrderBottom(n0);
        for (List<Integer> list : lists) {
            Uitls.printList(list);
        }

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode n = q.poll();
                list.add(n.val);
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
                size --;
            }
            lists.add(0, list);
        }
        return lists;
    }


     public static class TreeNode {
         int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
}
