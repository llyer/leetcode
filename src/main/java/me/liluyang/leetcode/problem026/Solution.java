package me.liluyang.leetcode.problem026;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * <p>
 * 移除数组中的重复元素
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 此处是改变数组的内容，不是删除数组内容，数组是有序的，倒序删除，移动元素比较方便
     *
     *
     * 双指针方法，一个快指针，一个慢指针，慢指针记录不同元素的最新位置，快指针遍历数组
     *
     * leetcode 的方法调用方需要判断数组的变化情况，所以要修改数组的内容
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

}
