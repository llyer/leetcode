package me.liluyang.leetcode;

class Solution155 {

    // 常数时间内检索到最小元素
    private Node node;

    /** initialize your data structure here. */
    public Solution155() {}

    public void push(int x) {
        if (node == null) {
            node = new Node(x, x);
        } else {
            node = new Node(x, Math.min(x, node.min), node);
        }
    }

    public void pop() {
        node = node.next;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.min;
    }

    // 自定义的栈内的节点，每个节点都直接冗余一个最小元素，就很方便的处理了 getMin 的情况，不需要做任何的多余处理
    // 用一个链表来实现栈，链表的头节点时栈顶，尾节点时栈尾
    class Node {
        int val;
        int min;
        Node next;

        public Node (int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }

        public Node (int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}