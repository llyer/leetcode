package me.liluyang.leetcode.problem268;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
    }

    /**
     * 寻找缺失的数字。寻找 0 - n 中缺失的数字，数组的长度为 n
     *
     * 解题思路： result = （1 + 2 + 3 + 。。。。 + n ) - 数组元素之和
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
        }
        int sum2 = nums.length * (1 + nums.length) / 2;
        return sum2 - sum1;
    }
}