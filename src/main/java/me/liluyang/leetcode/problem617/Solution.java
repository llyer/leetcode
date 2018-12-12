package me.liluyang.leetcode.problem617;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 * <p>
 * 860. 合并两个二叉树
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("");
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
