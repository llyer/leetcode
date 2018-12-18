package me.liluyang.leetcode.problem559;

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 * <p>
 * 559. Maximum Depth of N-ary Tree
 *
 *
 */
public class Solution {

    Integer depth = 0;

    Integer max = 0;

    /**
     * N叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root != null) {
            depth++; // 进入下一层深度加一
            if (max < depth) max = depth;
            for (Node node : root.children) {
                maxDepth(node);
            }
            depth--; // 返回上一层深度减一
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("");
    }

}
