package me.liluyang.leetcode.problem733;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
    }

    /**
     * 二维数组的深度优先搜索
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int sourceColor = image[sr][sc];
        if (newColor == sourceColor) return image;
        return dfs(image, sr, sc, sourceColor, newColor);
    }

    public int[][] dfs(int[][] image, int sr, int sc, int sourceColor, int newColor) {
        // 业务逻辑
        image[sr][sc] = newColor;
        if ((sr - 1) >= 0 && (image[sr - 1][sc] == sourceColor)) {
            dfs(image, sr - 1, sc, sourceColor, newColor);
        }

        if ((sr + 1) < image.length && (image[sr + 1][sc] == sourceColor)) {
            dfs(image, sr + 1, sc, sourceColor, newColor);
        }

        if ((sc - 1) >= 0 && (image[sr][sc - 1] == sourceColor)) {
            dfs(image, sr, sc - 1, sourceColor, newColor);
        }

        if ((sc + 1) < image[0].length && (image[sr][sc + 1] == sourceColor)) {
            dfs(image, sr, sc + 1, sourceColor, newColor);
        }
        return image;
    }
}