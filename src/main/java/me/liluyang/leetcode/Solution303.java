package me.liluyang.leetcode;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * url: https://leetcode-cn.com/problems/range-sum-query-immutable/comments/
 *
 * 解题思路：最简单的动态规划
 *
 * 题目要求的数据是第 i 天到第 j 天的数据和，如果每次求解时都进行循环，效率就比较低调用 n 次 时间复杂度就是 O（n*n）
 * 这时我们通过生成一个 sums 数组数据和，sum是从第零个节点到第 i 个节点的数据和
 * 这样我们计算第 i 个元素到第 j 个元素的数据和，就不用了再从 nums 数组求值，变成了从 sums 数据求值：
 * return i == 0 ? sums[j] : sums[j] - sums[i - 1];
 * 时间复杂度约为 O(nums.length) + O(n)，时间复杂度会降低很多
 * 其中 max(i) 和 minBefore 都需要在每次的循环中更新
 */
class NumArray {

    private int sums[];

    public NumArray(int[] nums) {
        if (nums.length == 0) return;
        sums = new int[nums.length];
        sums[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {

        return i == 0 ? sums[j] : sums[j] - sums[i - 1];
    }
}
