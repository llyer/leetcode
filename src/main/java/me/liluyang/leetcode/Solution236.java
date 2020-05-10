package me.liluyang.leetcode;

public class Solution236 {

    /**
     * 题目：236. 二叉树的最近公共祖先
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
     * 标签：树
     *
     * 需要注意的点有什么？
     *      1. 自己也是自己的祖先，例如 [4,2,3] p=4, q=2 那么就要返回 4
     *
     * 解题思路是森么？
     *
     *      1. 如果 root == null 返回 null
     *      2. 如果 root == p or root == q 返回 root
     *      3. 如果 root.left == null or root.right == null 能到这一步 root 本身已经不是 p or q 了，所以返回 null 就可以了
     *
     *      4. 遍历左节点和右节点
     *
     *      5. 对于树里面的任何一节点，如果 left == null 返回 right，是因为如果左节点返回 null 那么左边的子树一定不存在 p or q 这两个点和这两个节点的最近公共最先
     *      6. 同上
     *      7. return root 证明，左边的子树没有返回 null，右边也没有返回 null，证明 p,q 第一次在这里交汇了。所以将这个节点返回去就可以了
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        if (root.left == null && root.right == null) return null;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        System.out.println("");
    }

}
