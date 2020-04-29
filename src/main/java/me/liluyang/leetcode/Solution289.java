package me.liluyang.leetcode;

public class Solution289 {

    /**
     * 生命游戏
     *
     * 1. 复制一份新的二维数组
     * 2. 便利数组的每一个元素
     * 3. 判断每一个元素的当前状态，根据当前元素的数组状态推断下一个状态
     *
     * @param board
     */
    public static void gameOfLife(int[][] board) {


        int rows = board.length;
        int cols = board[0].length;

        int[][] next = new int[rows][cols];

        // 遍历 board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                next[i][j] = board[i][j];
            }
        }

        // 遍历 board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int liveCount = 0;

                // 遍历当前这个元素周围的八个元素
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        // 如果是自己，跳过不用判断
                        if (k == 0 && l == 0) continue;
                        int row = i + k;
                        int col = j +l;

                        // 在数组的范围内进行统计数据
                        if (row >= 0 && row < rows && col >= 0 && col < cols) if (next[row][col] == 1) liveCount++;
                    }
                }

                // 判断当前的  liveCount 是哪一种状态
                // 规则 1 或规则 3
                if ((next[i][j] == 1) && (liveCount < 2 || liveCount > 3)) {
                    board[i][j] = 0;
                }
                // 规则 4
                if (next[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }


    public static void main(String[] args) {

        int[][] nums = {{0,1,1},{1,1,1},{1,1,1}};
        gameOfLife(nums);
        System.out.println();
    }
}