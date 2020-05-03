package me.liluyang.leetcode;

/*
 * [53]
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 *
 */
class Solution53 {

    /**
     * 题目：53. 最大子序和
     * 链接：https://leetcode-cn.com/problems/maximum-subarray/description/
     * 标签：动态规划
     *
     * 解题思路
     *
     * 维基百科参考链接：https://zh.wikipedia.org/wiki/%E6%9C%80%E5%A4%A7%E5%AD%90%E6%95%B0%E5%88%97%E9%97%AE%E9%A2%98
     *
     * 到当前节点为止整个数组的最大子序和 maxSofar = max(maxSofar, maxEndingHere)
     *
     * maxEndingHere 以当前节点为最后一个节点的最大子序和，maxEndingHere 的计算方式为，max(之前节点的 maxEndingHere + nums[i] 和 nums[i] 的最大值)
     *
     * 所有 maxSofar的计算方式为 max(maxSofar, maxEndingHere) 为不包含当前节点的最大子序和
     *
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 遍历到当前节点的所有节点的最大子序列的和
        int maxSofar = nums[0];

        // 以当前节点节点为子序列终点的所有子序列的和
        int maxEndingHere = nums[0];

        for(int i=1;i<nums.length;i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSofar = Math.max(maxSofar,maxEndingHere);
        }
        return maxSofar;
    }
}

