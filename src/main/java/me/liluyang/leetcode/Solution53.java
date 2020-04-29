package me.liluyang.leetcode;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (42.25%)
 * Total Accepted:    39.2K
 * Total Submissions: 91.6K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */
class Solution53 {

    /**
     * 解题思路
     *
     * 维基百科参考链接：https://zh.wikipedia.org/wiki/%E6%9C%80%E5%A4%A7%E5%AD%90%E6%95%B0%E5%88%97%E9%97%AE%E9%A2%98
     *
     * 当前节点的最大子序和 maxsofar = max(maxsofar, maxending)
     *
     * maxending 为包含当前节点的最大子序和，maxending 的计算方式为，max(之前节点的 maxending + nums[i] 和 nums[i] 的最大值)
     *
     * maxsofar 为不包含当前节点的最大子序和
     *
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 最大子序和
        int maxsofar = nums[0];

        // 包含最后一个节点的最大子序和
        int maxending = nums[0];

        for(int i=1;i<nums.length;i++) {
            maxending = Math.max(nums[i], maxending + nums[i]);
            maxsofar = Math.max(maxsofar,maxending);
        }
        return maxsofar;
    }
}

