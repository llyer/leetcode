package me.liluyang.leetcode.problem700;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * <p>
 * 700. Search in a Binary Search Tree
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("");
    }

    Integer prev = null;

    /**
     * 搜索二叉树查找数据
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        // 如果不存在，返回 null
        if (prev != null && ((prev < val && val < root.val) || (prev > val && val > root.val))) {
            return null;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    /**
     * 遍历二叉树，二叉树当前节点的值，如果左右两棵树都有，那就合并，左边有右边没有那就取左边的，反之同理
     *
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 节点的值合并
        t1.val = t1.val + t2.val;
        // 继续
        t1.left = mergeTrees(t1.left, t2 != null ? t2.left : null);
        t1.right = mergeTrees(t1.right, t2 != null ? t2.right : null);
        return t1;
    }
}
