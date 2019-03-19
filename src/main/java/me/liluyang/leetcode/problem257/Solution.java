package me.liluyang.leetcode.problem257;

import java.util.List;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        String str = "a->b->c";
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.lastIndexOf("->"));
        System.out.println(sb.toString());
        System.out.println(sb.delete(4, sb.length()));
    }

    List list = new ArrayList<String>();

    StringBuilder sb = new StringBuilder();

    /**
     * 二叉树的所有路径。返回值是所有路径组合成的数组
     *
     * 解题思路：依然是深度优先搜索。需要一个全局的字符数组变量，在递归的过程中将结果给保存下来
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return list;
        dfs(root, sb); // 递归生成路径字符串
        return list;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        if(sb.length() == 0) sb.append(node.val); // 添加字符串
        else sb.append("->" + node.val);
        if (node.left == null && node.right == null) {
            list.add(sb.toString());
        }
        if (node.left != null){
            dfs(node.left, sb);
            sb.delete(sb.lastIndexOf("->"), sb.length()); // 删除左子树中添加的字符串，然后开始遍历右子树的字符串
        }
        if (node.right != null) {
            dfs(node.right, sb);
            sb.delete(sb.lastIndexOf("->"), sb.length()); // 删除左子树中添加的字符串，然后开始遍历右子树的字符串
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
