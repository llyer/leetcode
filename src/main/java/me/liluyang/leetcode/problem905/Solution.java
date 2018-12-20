package me.liluyang.leetcode.problem905;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class Solution {

    public static void main(String[] args) {
        int[] values = {0,1,2};
        System.out.println(Arrays.toString(sortArrayByParity(values)));
    }


    /**
     * 数组排序，偶数数据在前，奇数数据在后
     * 思路：两个指针，新建一个数组，遍历原数组根据奇数和偶数的条件将数据插入对应位置
     * @param A
     * @return
     */
    public static int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) return null;
        int[] result = new int[A.length];
        int oddIndex = 0;
        int evenIndex = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[oddIndex] = A[i];
                oddIndex++;
            } else {
                result[evenIndex] = A[i];
                evenIndex--;
            }
        }
        return result;
    }
}
