package me.liluyang.leetcode;

public class Solution643 {

    /**
     * 时间复杂度 O(n)
     *
     * 找出最大的平均数
     *
     * 需要有三个临时变量，一个存储最大结果，一个存储前k个的和，一个存储 k个的和  + nums[i] - nums[i-k] 的新值
     *
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        double result = 0;
        double oldFour = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                oldFour = oldFour + nums[i];
                result = oldFour;
            } else {
                double newFour = oldFour + nums[i] - nums[i-k];
                result = Math.max(result, newFour);
                oldFour = newFour;
            }
        }
        return result / k;
    }

    public static void main(String[] args) {
        // double 转 int 是向下取整
        int nums[] = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));
    }
}