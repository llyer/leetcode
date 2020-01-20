package me.liluyang.leetcode;

public class Solution485 {

    /**
     * 很简单的题，一次遍历即可解决问题
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for ( int num: nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            }
            else count = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}