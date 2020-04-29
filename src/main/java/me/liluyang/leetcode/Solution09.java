package me.liluyang.leetcode;

public class Solution09 {
    /**
     * 判断一个整数是否是回文数字 121，12321是，123 1234不是
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        int origin = x;
        int result = 0;

        if (x < 0) return false;

        // 123
        while (x > 0) {
            int temp = x % 10;
            x = x / 10;
            result = result * 10 + temp;
        }

        if (result == origin) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(121));
    }

}