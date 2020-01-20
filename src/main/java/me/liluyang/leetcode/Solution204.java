package me.liluyang.leetcode;

public class Solution204 {

    /**
     * 思路一：使用 isPrime 方法判断
     *
     * 思路二：快速判断质数和偶数的方法，一次遍历，2的所有倍数不是质数，3的所有倍数不是质数，一次类推，时间复杂度为O(n)
     *
     * 返回质数的个数
     */
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    /**
     * 判断一个数是不是质数，如果在2到 sqrt(num) 的范围内可以被整除，那么就是质数
     *
     * @param num
     * @return
     */
    public static Boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * 第二种是死路，快速计算出所有的偶数，使用排除法，余下的所有数字就是素数
     *
     * @param n
     * @return
     */
    public static int countPrimes2(int n) {
        if (n <= 2) return 0;
        int count = 0;
        int[] flags = new int[n];
        flags[0] = 1;
        flags[1] = 1;
        for (int i = 2; i < flags.length; i++) {
            int beishu = 2;
            while (i * beishu < n) {
                if (flags[i * beishu] != 1) {
                    flags[i * beishu] = 1;
                }
                beishu++;
            }
        }
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] == 0) count++;
        }
        return  count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes2(10));
    }
}