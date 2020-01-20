package me.liluyang.leetcode;

public class Solution835 {


    /**
     * 解题思路: 本题核心的思路是如何正确的遍历出两个二维数组的所有重叠情况。
     *
     * 我们可以假设两个二维数组为 A，B。我们让A静止，B可以随意的移动
     *
     * 假设数组的长度为2，那么B相对A的偏移量有[0,0] [0,1] [1,0] [1,1]
     *                                      [-0,-0] [-0,-1] [-1,-0] [-1,-1]
     * 假设数组的长度为3，那么B相对A的偏移量有[0,0] [0,1] [0,2] [1,0] [1,1] [1,2] [2,0] [2,1] [2,2]
     *                                      [-0,-0] [-0,-1] [-0,-2] [-1,-0] [-1,-1] [-1,-2] [-2,-0] [-2,-1] [-2,-2]
     *
     * 假设数组的长度为4，那么B相对A的偏移量有 4 * 4 * 2
     *
     * 可以明显的发现一共有 length * length * 2 种情况，这需要一个双层循环
     *
     * 在对应的每一种的偏移量下，我们要计算出对应情况下的重叠 count 的值。这需要一个双层循环。
     *
     * 综上所述，我们需要一个四层循环就可以计算出最大重叠 max 的值
     *
     *
     *
     *
     * @param A
     * @param B
     * @return
     */
    public static int largestOverlap(int[][] A, int[][] B) {
        Integer length = A.length;
        Integer max = 0;
        for (int offsetX = 0; offsetX < length; offsetX++) {
            for (int offsetY = 0; offsetY < length; offsetY++) {
                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i + offsetX < length; i++) {
                    for (int j = 0; j + offsetY < length; j++) {
                        // 第二个矩阵B相对A向右偏移
                        if (A[i + offsetX][j + offsetY] == B[i][j] && B[i][j] == 1) count1++;

                        // 第二个矩阵B相对A向左偏移
                        if (A[i][j] == B[i + offsetX][j + offsetY] && A[i][j] == 1) count2++;
                    }
                }
                System.out.println(count1 + " " + count2);
                max = Math.max(Math.max(count1, count2), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] a = {{1,1,0},{0,1,0},{0,1,0}};
        int[][] b = {{0,0,0},{0,1,1},{0,0,1}};

        System.out.println(largestOverlap(a, b));
    }
}