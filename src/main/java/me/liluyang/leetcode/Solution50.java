package me.liluyang.leetcode;

public class Solution50 {

    /**
     * 题目：50. Pow(x, n)
     * 链接：https://leetcode-cn.com/problems/powx-n/
     * 标签：数学
     *
     * 解题思路是什么？
     *      x 的 n 次方中的 n 转变为 2 进制的，可以将时间复杂度降低为为O(logN)
     *
     * 有什么要注意的点？
     *      1. 注意  n 次方的正负问题， 2的-2次方等于四分之一
     *
     */
    public double myPow(double x, int n) {
        long longn = n;
        return longn > 0 ? powFoo(x,longn) : 1.0 / powFoo(x, -longn);
    }

    /**
     * @param num
     * @param longn
     * @return
     */
    private double powFoo(double num, long longn) {
        long result = 1;
        double baseNum = num;
        while (longn > 0) {
            if (longn % 2 == 1) result *= baseNum;
            baseNum *= baseNum;
        }
        return result;
    }
}
