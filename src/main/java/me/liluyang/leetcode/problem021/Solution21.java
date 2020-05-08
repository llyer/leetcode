package me.liluyang.leetcode.problem021;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * <p>
 * 合并两个有序数组，合并后仍然有序
 */
public class Solution21 {


    /**
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;

        ListNode result;
        if (l1 == null) {
            result = l2;
            l2 = l2.next;
        } else if (l2 == null) {
            result = l1;
            l1 = l1.next;
        } else if (l1.val >= l2.val) {
            result = l2;
            l2 = l2.next;
        } else {
            result = l1;
            l1 = l1.next;
        }

        ListNode head = result;

        System.out.println("l1=" + l1);
        System.out.println("l2=" + l2);

        while (!(l1 == null && l2 == null)) {
            if (l1 == null) {
                head.next = l2;
                l2 = null;
            } else if (l2 == null) {
                head.next = l1;
                l1 = null;
            } else if (l1.val >= l2.val) {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            } else {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(l1.next.next.next);
        System.out.println(l1.next.next.val);
        System.out.println(l2.next.next.val);
        System.out.println("---" + mergeTwoLists(l1, l2).next.next.val);
    }


    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
