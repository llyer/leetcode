package me.liluyang.leetcode;

/**
 * 思路：字符串替换
 */
public class Solution507 {

    /**
     * 要验证一个数字是否是 “完美数”，我们需要获得这个数所有可能的正因子
     *
     * 那么我们需要从 1 开始，遍历到这个数字的二分之一大小，计算所有的正因子的和
     *
     * 然后正确的代码如下：
     *
     *
     *
     * @param num
     * @return
     */
    public static boolean checkPerfectNumber(int num) {
        if (num == 0) return false;
        int count = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                count += i;
            }
        }
        return  count == num ? true : false;
    }


    /**
     * 第二种思路，如果一个数 n 有一个大于 sqrt(n)（平方根）的正因子，那么一定有一个小于平方根的正因子。
     *
     * 那么循环到数字的 sqrt(n) 就可以结束了，因为我们可以从小的正因子获取大的正因子
     *
     * 如果 num == 2
     * @param num
     * @return
     */
    public static boolean checkPerfectNumber2(int num) {
        if (num == 0) return false;
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count += i;
                if (i * i != num) {
                    count += num / i;
                }
            }
        }
        return  count / 2 == num ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(27));
    }
}