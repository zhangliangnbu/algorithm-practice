package com.liang.algorithm.leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next= new ListNode(4);

        printList(offical(l1, l2));
    }

    public static ListNode my1(ListNode l1, ListNode l2) {
        // sol: 两个指针，遍历
        // time O(m+n)
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1, p2 = l2, p3, l3;
        if (p1.val < p2.val) {
            l3 = p1;
            p1 = p1.next;
        } else {
            l3 = p2;
            p2 = p2.next;
        }
        p3 = l3;

        while (true) {
            if (p1 == null) {
                p3.next = p2;
                break;
            }

            if (p2 == null) {
                p3.next = p1;
                break;
            }

            if (p1.val < p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }

        return l3;
    }

    private static ListNode offical(ListNode l1, ListNode l2) {
        // 对我的方法的优化，代码更加简洁，思路一样
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static void printList(ListNode l) {
        System.out.println();
        ListNode p = l;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }

}
