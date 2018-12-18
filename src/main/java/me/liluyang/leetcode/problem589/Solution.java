package me.liluyang.leetcode.problem589;

import java.util.*;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
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
