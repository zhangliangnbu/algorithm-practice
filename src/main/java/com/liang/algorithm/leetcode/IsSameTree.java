package com.liang.algorithm.leetcode;

public class IsSameTree {

    public static void main(String[] args) {
        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(2);
        TreeNode n13 = new TreeNode(3);
        n11.left = n12;
//        n11.right = n13;

        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(2);
        TreeNode n23 = new TreeNode(3);
        n21.left = n22;
        n21.right = n23;

        System.out.println(my1(n11, n21));
    }

    public static boolean my1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val !=- q.val) {
            return false;
        }
        return my1(p.left, q.left) && my1(p.right, q.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
