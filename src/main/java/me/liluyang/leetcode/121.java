package me.liluyang.leetcode;

class Solution121 {
    /**
     *
     * problem: 121. 买卖股票的最佳时机
     *
     * url: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/submissions/
     *
     * 解题思路：最简单的动态规划
     *
     * 在第 i 天时可能产生的最大的利润是 Max(i) = Max(Max(i-1), prices[i] - minBefore);
     *
     * 其中 max(i) 和 minBefore 都需要在每次的循环中更新
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 校验输入
        if (prices.length == 0) return 0;

        int minBefore = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minBefore = Math.min(minBefore, prices[i]); // 比较之前最小的和现在最小的

            maxProfit = Math.max(maxProfit, prices[i] - minBefore);
        }
        return maxProfit;
    }
}