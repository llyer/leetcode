package me.liluyang.leetcode.problem746;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class Solution {

    public static void main(String[] args) {
//        int[] values = {2,7,9,3,1};
        int[] values = {0,0,1,1};
        // 自己写的递归算法在解决这个问题的时候超时了。结果是 4173 是正确的，但是超时了
//        int[] values = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        int[] a1 = Arrays.copyOf(values, 3);
//        System.out.println(Arrays.toString(values));
//        System.out.println(Arrays.toString(a1));
        System.out.println(minCostClimbingStairs(values));
    }


    /**
     * 最小花费爬楼梯
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        int min1 = 0;
        int min2 = 0;
        int min = Math.min(min1, min2);
        // 由于计算的是楼顶，也就是到数组的下一个位置的花费，所以我们计算的时候溢出一位
        for (int i = 2; i <= cost.length; i++) {
            min = Math.min(min1 + cost[i-2], min2 + cost[i-1]);
            min1 = min2;
            min2 = min;
        }
        return min;
    }
}
