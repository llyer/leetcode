package me.liluyang.leetcode.problem589;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 * <p>
 * 589. N-ary Tree Preorder Traversal N叉树前序遍历
 *
 *
 */
public class Solution {

    List<Integer> list = new ArrayList();

    public List<Integer> preorder(Node root) {
        if (root != null) {
            list.add(root.val);
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("");
    }

}
