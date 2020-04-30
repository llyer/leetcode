package me.liluyang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution202 {

    /**
     * 获取下一位数字
     *
     * @param n
     * @return
     */
    int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + n%10;
            n = n / 10;
        }
        return sum;
    }

    /**
     * 数字判断是否是快乐数
     *
     * 1. 创建一个 HashSet 来放入所有的数字，如果 HashSet 中已经有该数字那么证明已经开始进入循环了。
     * 2. 如果数字跌落到1，那么证明就是快乐数
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set nums = new HashSet<>();
        while (!nums.contains(n)) {
            if (n == 1) return true;
            nums.add(n);
            n = getNext(n);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}