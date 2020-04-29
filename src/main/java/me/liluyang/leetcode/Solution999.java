package me.liluyang.leetcode;

public class Solution999 {

    /**
     * 可以被一步捕获的棋子
     *
     * 1. 找到车的位置
     * 2. 四个方向判断是否有可以吃到的棋子
     *
     * @param board
     * @return
     */
    public static int numRookCaptures(char[][] board) {

        int row = 0, col = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println("坐标找到，" + row + col);

        int count = 0;
        int tempRow = row;
        int tempCol = col;
        while (tempRow >= 0) {
            // 自己的象
            if (board[tempRow][tempCol] == 'B') break;
            // 对面的卒
            if (board[tempRow][tempCol] == 'p') {
                count++;
                break;
            }
            tempRow--;
        }

        tempRow = row;
        while (tempRow < 8) {
            if (board[tempRow][tempCol] == 'B') break;
            if (board[tempRow][tempCol] == 'p') {
                count++;
                break;
            }
            tempRow++;
        }

        // 元素大于等于零，元素不为
        tempRow = row;
        while (tempCol >= 0) {
            if (board[tempRow][tempCol] == 'B') break;
            if (board[tempRow][tempCol] == 'p') {
                count++;
                break;
            }
            tempCol--;
        }

        tempCol = col;
        while (tempCol < 8) {
            if (board[tempRow][tempCol] == 'B') break;
            if (board[tempRow][tempCol] == 'p') {
                count++;
                break;
            }
            tempCol++;
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
        };
        System.out.println("hello world");
        System.out.println("count" + numRookCaptures(chars));
    }
}