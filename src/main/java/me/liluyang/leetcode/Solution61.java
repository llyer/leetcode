package me.liluyang.leetcode;

class Solution61 {

    /**
     * 题目：61. 旋转链表
     * 链接：https://leetcode-cn.com/problems/rotate-list/
     * 标签 链表
     *
     * 解题思路：
     *      链接循环 n 次
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0) return head;

        ListNode tail = head;

        // 1. 计算链表大小，将链表形成闭环
        int size = 1;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        k = k % size;
        tail.next = head;

        // 2. 链表旋转 k 遍，头指针指向尾指针，微针
        for (int i = 0; i < k; i++) {
            head = tail;
            while (tail.next != head) tail = tail.next;
        }

        // 3. 断开链表
        tail.next = null;

        return head;
    }

    /**
     *
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}