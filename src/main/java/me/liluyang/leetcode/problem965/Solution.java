package me.liluyang.leetcode.problem965;


public class Solution {

    /**
     * 判断是否是单值二叉树
     *
     * 解题思路：当前树是否是单值二叉树需要满足二个条件，第一当前节点的值等于 “单值”，第二左子树和右子树也都满足单值二叉树
     *
     * 左子树的结果和右子树是 “与” 操作，任意一个左子树或者右子树不满足条件，就不是单值二叉树
     *
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        return dfs(root, val);
    }

    public boolean dfs(TreeNode node, int val) {
        if (node == null) return true;
        return node.val == val && dfs(node.left, val) && dfs(node.right, val);
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