package me.liluyang.leetcode;

/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 *
 * https://leetcode-cn.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (42.61%)
 * Total Accepted:    31.6K
 * Total Submissions: 73.7K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 
 * 
 * 示例 3:
 * 
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 
 * 
 * 示例 4:
 * 
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 
 * 
 */
class Solution35 {

    // 思路，二分查找
    public int searchInsert(int[] nums, int target) {
        int min = 0, max = nums.length, mid = (min+ max) / 2;

        while (min < max) {
            if ( nums[mid] == target) return mid;
            else if (target < nums[mid]) {
                max = mid - 1;
                mid = (min + max) / 2;
            } else {
                min = mid + 1;
                mid = (min + max) / 2;
            }
        }

        return mid + 1;
    }
}

