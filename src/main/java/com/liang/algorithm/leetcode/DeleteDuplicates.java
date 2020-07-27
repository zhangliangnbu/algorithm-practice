package com.liang.algorithm.leetcode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode r = my1(n1);

        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    // 双指针 O(n)
    public static ListNode my1(ListNode head) {
        ListNode p = head, pre = null;
        while (p != null) {
            if (pre == null || p.val != pre.val) {
                pre = p;
            } else {
                pre.next = p.next;
            }
            p = p.next;
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
