package me.liluyang.leetcode;

public class Solution983 {

    /**
     * 题目：983. 最低票价
     * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets/
     * 标签：动态规划
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length; // 出行的天数数组
        int maxDay = days[len - 1]; // 最后要出行的那天
        int minDay = days[0]; // 出行的第一天
        int[] dp = new int[maxDay + 31]; // 动态规划数组，每天出行的最小花费，多扩几天，省得判断 365 的限制

        // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            // i 表示 days 的索引
            // 也可提前将所有 days 放入 Set，再通过 set.contains() 判断
            if (d == days[i]) {
                dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
                dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
                i--; // 别忘了递减一天
            } else dp[d] = dp[d + 1]; // 不需要出门
        }
        return dp[minDay]; // 从后向前遍历，返回最前的 minDay，第一天的最小值就是我们要的值
    }

    /**
     * 数组
     * @param args
     */
    public static void main(String[] args) {
        int[][] a = {{1,1,0},{0,1,0},{0,1,0}};
        int[][] b = {{0,0,0},{0,1,1},{0,0,1}};
        System.out.println();
    }
}