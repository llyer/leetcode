package me.liluyang.leetcode.problem766;

public class Solution {

    /**
     * 托普利茨矩阵
     *
     * 解题思路：根据题意我们需要以矩阵的第一行和第一列为起点判断矩阵上所有的点，如果所有对应的对角线满足条件那么就是，如果不满足，那就不是
     *
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // 处理第一列为起点的元素进行判断
        for (int i = 0; i < matrix.length; i++) {
            int start = matrix[i][0];
            int row = i;
            int col = 0;
            while (row < matrix.length && col < matrix[0].length) {
                if (matrix[row][col] != start) return false;
                row = row + 1;
                col = col + 1;
            }
        }
        // 处理第一行为起点的元素进行判断
        for (int i = 0; i < matrix[0].length; i++) {
            int start = matrix[0][i];
            int row = 0;
            int col = i;
            while (row < matrix.length && col < matrix[0].length){
                if (matrix[row][col] != start) return false;
                row = row + 1;
                col = col + 1;
            }
        }
        return true;
    }

}
