package me.liluyang.leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution98 {

    /**
     * 题目：98. 验证二叉搜索树
     * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree/
     * 标签：二叉树，前序遍历，中序遍历等等
     *
     * 解题思路？
     *  二叉树中序遍历变成数组，如果数组是有序的，那么就是二叉搜索树
     *
     *  1. 中序遍历二叉树
     *  2. 验证数组是否有序
     *
     * @param root 根节点
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        mid(root);
        System.out.println("size " + arrs.size());
        return isSorted(arrs);
    }

    private List<Integer> arrs = new ArrayList();

    // 中序遍历
    public void mid(TreeNode root) {
        if (root == null) return;
        mid(root.left);
        arrs.add(root.val);
        mid(root.right);
    }

    // 判断数组是否有序
    boolean isSorted(List<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) >= array.get(i + 1))
                return false;
        }
        return true;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}



