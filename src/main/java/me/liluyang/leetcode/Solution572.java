package me.liluyang.leetcode;

public class Solution572 {

    // 这个就是LeetCode100 题的那个函数
    public boolean isSameTree(TreeNode s, TreeNode t) {
        // 同时为空 说明树一起到底，两树相同
        if (s == null && t == null) {
            return true;
        }
        // 如果上面没有返回值，说明必有一个没有为空（有可能两个都不为空）
        if (s == null || t == null) {
            return false;
        }
        // 如果判断到了这一步，说明两个都不为空
        // 先序遍历 自己--左 -- 右
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    /**
     * 题目：572. 另一个树的子树
     * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree/
     * 标签：树
     * <p>
     * 解题思路：判断一个树是否为另外一个树的子树只需要判断 s == t || s == t.left || s == t.right
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 我s都遍历完了。你居然还没匹配上。那就返回false
        if (s == null) {
            return false;
        }
        // 短路运算符，有一个为真，返回真
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     *
     * 解题思路：将树中序遍历为字符串，然后判断 s.indexOf(t) 是否 > -1
     *
     * 错误原因：上面的思路并不能真正的判断 t 为 s 的子树，例如 s = [3,4,5,1,2,null,null,0] t = [4,1,2]
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtreeError(TreeNode s, TreeNode t) {
        dfs(s);
        dfs(t);
        System.out.println("sb1 " + sb1.toString());
        System.out.println("sb2 " + sb2.toString());
        return sb1.toString().indexOf(sb2.toString()) > -1;
    }

    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    public void dfs(TreeNode s) {
        if (s != null) dfs(s.left);
        sb1.append(s == null ? null : s.val);
        if (s != null) dfs(s.right);
    }

    public void dfs1(TreeNode t) {
        if (t != null) dfs1(t.left);
        sb2.append(t == null ? null : t.val);
        if (t != null) dfs1(t.right);
    }



    /**
     * 数组
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println();
    }


    // 树节点
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}