package me.liluyang.leetcode;

public class Solution11 {

    /**
     * 编号：0011
     * 名称：盛最多水的容器
     * 链接：https://leetcode-cn.com/problems/container-with-most-water/
     * 标签：双指针
     *
     *
     * 1. 最优解题方法是什么？
     *      双指针。参数是一个一位数组，计算开始时，分别让两个指针置于左右两端，再根据情况移动就涵盖了所有的情况
     *
     * 2. 为什么每次都是移动两个指针中值更小的那个指针？
     *      因为 maxResult 的计算方式为 Math.min(height[min], height[max]) * (max - min)，所以每次移动指针，两个指针的距离在靠近，而如果较小的那个值不变，每次移动后 maxResult 的值必定会减少
     *      所以，只有移动值更小的那个指针，才有可能让 maxResult 变大
     *
     * @param height 高度数组
     * @return 可能容纳的雨水的最大值
     */
    public static int maxArea(int[] height) {
        int min = 0;
        int max = height.length - 1;
        int maxResult = 0;

        while (min < max) {
            int count = Math.min(height[min], height[max]) * (max - min);
            if (maxResult < count) maxResult = count;
            if (height[min] < height[max]) min++;
            else max--;
        }
        return maxResult;
    }


    public static void main(String[] args) {

        int[] nums = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(nums));
    }
}