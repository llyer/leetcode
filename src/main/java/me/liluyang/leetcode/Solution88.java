package me.liluyang.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * <p>
 * 合并两个有序数组，合并后仍然有序
 */
public class Solution88 {

    public static void main(String[] args) {

        int[] nums1 = {1,3,4,0,0,0};
        int[] nums2 = {5,1,2};
        System.out.println("");
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 将第二个数组放到第一个数组
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        // 冒泡排序
        for (int i = 0; i < m + n; i++) {
            for (int j = 0; j < m + n - i - 1; j++) {
                // 交换位置
                if (nums1[j] > nums1[j + 1]) {
                    int temp = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1] = temp;
                }
            }
        }
    }

}
