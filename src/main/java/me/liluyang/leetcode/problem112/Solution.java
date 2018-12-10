package me.liluyang.leetcode.problem112;

class Solution {
    public static void main(String[] args) {
//        System.out.println(isPalindrome(123));
    }

    /**
     * https://leetcode.com/problems/path-sum/
     *
     * 二叉树，判断二叉树是否存在一条从根节点到叶子节点的路径，并且这条路径加起来等于给定的参数 sum
     *
     * 方法：递归
     * 关键思路：左节点和右节点的权重是相同的，返回值是，左节点和右键点的返回值关系为或
     * 收集各个叶子节点的值，一路或到根节点，就可以得到整个树的值
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) return root.val - sum == 0;

        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);

        return  left || right;
    }
}