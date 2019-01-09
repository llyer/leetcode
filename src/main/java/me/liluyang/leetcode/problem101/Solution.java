package me.liluyang.leetcode.problem101;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if ( left != null && right != null) {
            if ( left.val == right.val) {
                return dfs(left.left, right.right) && dfs(left.right, right.left);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 错误思路
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        // 叶子比较
        // 深度优先搜索
        List<Integer> nodes = new ArrayList<Integer>();
        dfs2(root, nodes);
        System.out.println(nodes);

        for (int i = 0; i < nodes.size() / 2; i++) {
            if (nodes.get(i) != nodes.get(nodes.size() - 1 - i)) return false;
        }
        return true;
    }

    /**
     *
     * 错误思路
     * @param root
     * @param nodes
     */
    public void dfs2(TreeNode root, List<Integer> nodes) {
        if (root.left == null && root.right != null) {
            nodes.add(null);
            nodes.add(root.val);
            dfs2(root.right, nodes);
        } else if(root.left == null && root.right == null) {
            nodes.add(root.val);
        } else if (root.left != null && root.right != null) {
            dfs2(root.left, nodes);
            nodes.add(root.val);
            dfs2(root.right, nodes);
        } else if (root.left != null && root.right == null) {
            dfs2(root.left, nodes);
            nodes.add(root.val);
            nodes.add(null);
        }
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