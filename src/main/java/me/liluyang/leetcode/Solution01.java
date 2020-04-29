package me.liluyang.leetcode;

public class Solution01 {

    /**
     * nums 是一个数组，target 是结果，数组里面必定存在两个数字加起来等于 target
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        // 遍历数字的所有加法组合
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        twoSum(arr, 9);
    }
}