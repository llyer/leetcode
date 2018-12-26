package me.liluyang.leetcode.problem155;

public class MinStack {

    // 常数时间内检索到最小元素
    private Node node;

    /** initialize your data structure here. */
    public MinStack() {}

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
