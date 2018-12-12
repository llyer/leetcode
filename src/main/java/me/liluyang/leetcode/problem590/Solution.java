package me.liluyang.leetcode.problem590;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 * <p>
 * 590. N-ary Tree Postorder Traversal
 *
 *
 */
public class Solution {

    List<Integer> list = new ArrayList();

    /**
     * N叉树的后续遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (Node node : root.children) {
                postorder(node);
            }
            list.add(root.val);
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println("");
    }

}
