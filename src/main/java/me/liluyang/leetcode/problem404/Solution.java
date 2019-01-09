package me.liluyang.leetcode.problem404;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
    }

    /**
     * 本质还是二叉树的遍历
     *
     * 1. 求所有左叶子节点的值的和，那就是求当前节点的左节点和右节点的所有左叶子节点的和
     *
     * 2. 不是左叶子节点返回值为0，是左叶子节点放回叶子的值
     *
     * 3. 递归求和即可
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    public int dfs(TreeNode node, Boolean isLeft) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            if (isLeft == true) return node.val;
            else return 0;
        }
        int leftVal = dfs(node.left, true);
        int rightVal = dfs(node.right, false);
        return leftVal + rightVal;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}