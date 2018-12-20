package me.liluyang.leetcode.problem198;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class Solution {

    public static void main(String[] args) {
//        int[] values = {2,7,9,3,1};
        // 自己写的递归算法在解决这个问题的时候超时了。结果是 4173 是正确的，但是超时了
        int[] values = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        int[] a1 = Arrays.copyOf(values, 3);
//        System.out.println(Arrays.toString(values));
//        System.out.println(Arrays.toString(a1));
        System.out.println(rob(values));
    }


    /**
     * 动态规划的思路，但是顺序执行代码。由上一个下一个状态的值，有前面的状态决定
     *
     * @param values
     * @return
     */
    public static int rob(int[] values) {
        if (values == null || values.length == 0) return 0;
        if (values.length == 1) return values[0];
        int max1 = values[0];
        int max2 = Math.max(values[0], values[1]);
        int max = Math.max(max1, max2);
        for (int i = 2; i < values.length; i++) {
            max = Math.max(max1 + values[i], max2);
            max1 = max2;
            max2 = max;
        }
        return max;
    }

    /**
     * 动态规划，核心的问题就是，重复子问题。
     *
     * @param values
     * @return
     */
    public static int rob2(int[] values) {
        if (values == null || values.length == 0) return 0;
        int index = values.length - 1;
        return foo(values, index);
    }

    public static int foo(int[] values, int index) {
        if (index == 0) return values[index];
        if (index == 1) return Math.max(values[0], values[1]);
        else return Math.max(foo(values, index - 1), foo(values, index -2) + values[index]);
    }


    /**
     * leetcode 讨论区参考答案
     * @param nums
     * @return
     */
    public static int rob3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length, i = 2;
        if (len == 1) return nums[0];
        int[] f = new int[len];
        f[0] = nums[0];
        f[1] = Math.max(f[0], nums[1]);
        for (; i < len; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
        }
        return f[i - 1];
    }
}
