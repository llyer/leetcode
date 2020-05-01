package me.liluyang.leetcode;

class Solution21 {

    /**
     * 题目：21. 合并两个有序链表
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
     * 标签：链表
     *
     * 1. 当两个链表都不为 null 时就一直循环比较两个备选链表
     * 2. 每次比较 l1.val l2.val 。将较小的值添加到新的链表中，新链表头指针前移一位，被选用的链接（l1 or l2）也前移一位
     * 3. 最后如果 l1 or l2 有剩下，那么直接放在新链表的尾部就行了
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(1);
        ListNode head = result;
        while (l1 != null && l2 != null) {
            System.out.println("l1 " +  l1.val);
            System.out.println("l2 " +  l1.val);
            if (l1.val < l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                result.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }

        if (l1 == null && l2 != null) head.next = l2;
        if (l1 != null && l2 == null) head.next = l1;
        return  result.next;
    }


    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}

