package me.liluyang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution102 {

    /**
     * 102. 二叉树的层序遍历
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * 标签：二叉树，宽度优先搜索
     *
     * 二叉树标准层次遍历，使用一个临时队列保存节点列表，在各个节点出队列的时候，访问这个节点的下一层就可以了。
     *
     * 然后记录下层级返回就可以
     *
     * @param root 根节点
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return null;

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> temp = new LinkedList<>();

        temp.add(root);

        int level = 1;
        while (temp.size() != 0) {
            List<Integer> levelTemp = new ArrayList<>();
            int size = temp.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = temp.poll();
                levelTemp.add(poll.val);
                System.out.println("poll " +  poll.val);
                if (poll.left != null) temp.add(poll.left);
                if (poll.left != null) temp.add(poll.right);
            }
            System.out.println("level " +  level);
            result.add(levelTemp);
            level++;
        }
        return result;
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



