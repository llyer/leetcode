package me.liluyang.leetcode;

public class Solution221 {

    /**
     * 题目：221. 最大正方形
     * 链接：https://leetcode-cn.com/problems/maximal-square/
     * 标签：动态规划
     *
     * 解题思路？
     *      动态规划题目的核心都是找到状态转移方程
     *
     * 动态规划的状态转移思路是什么呢？
     *      正方形可以转变为一个点加上一条边，和这个点所处的正方形的位置确定，左上，右上，左下，右下
     *      所有我们规定使用的点为右下，那么如果要确定以这个点为右下角的最大正方形，就是要找出这个点可能存在的最长边
     *
     *      遍历完正方形中的所有点，每一个节点的状态由前几个状态的最小值决定：
     *          前几个状态分别为：左，左上，上 三个节点（这三节节点为正方形的右下角节点时）决定，
     *          dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i][j]) + 1;
     *
     * 需要注意的点：
     *      1. 判断是不是字符串使用字符判断 matrix[i][j] == '1'
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[height+1][width+1];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ('1' == matrix[i][j]) {
                    System.out.println(matrix[i][j]);
                    dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i][j]) + 1;
                    maxSide = Math.max(maxSide,dp[i+1][j+1]);
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}