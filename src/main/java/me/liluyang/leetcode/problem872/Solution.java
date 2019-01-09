package me.liluyang.leetcode.problem872;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
    }

    /**
     * 问题 872
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 叶子比较
        // 深度优先搜索
        List<Integer> leafs01 = new ArrayList<Integer>();
        List<Integer> leafs02 = new ArrayList<Integer>();
        dfs(root1, leafs01);
        dfs(root2, leafs02);
        System.out.println(leafs01);
        System.out.println(leafs02);
        return leafs01.equals(leafs02);
    }

    public void dfs(TreeNode root, List<Integer> leafs) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
        } else {
            dfs(root.left, leafs);
            dfs(root.right, leafs);
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