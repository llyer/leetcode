package me.liluyang.leetcode;

public class Solution633 {

    /**
     * 方法一： 使用 sqrt 函数
     *
     * 循环的数值要用 long，否则长度不够用
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        if (c == 0) return true;
        for (long i = 1; i * i <= c; i++) {
            double sqrt = Math.sqrt(c - i*i);
            if (sqrt == (int)sqrt) return true;
        }
        return false;
    }

    /**
     * 方法二： 双指针，也要使用 。sqrt 函数
     *
     * 循环的数值要用 long，否则长度不够用
     * @param c
     * @return
     */
    public boolean judgeSquareSum2(int c) {
        if (c == 0) return true;
        long i = 0, j = (int)Math.sqrt(c);
        while (i <= j) {
            if (i * i + j * j == c) return true;
            else if (i * i + j * j > c) j = j - 1;
            else if (i * i + j * j < c) i = i + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        // double 转 int 是向下取整
        System.out.println((int)Math.sqrt(10));
    }
}