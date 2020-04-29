package me.liluyang.leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * 反转数字
 *
 * 错误：测试用例 1534236469 会报错，因为反转之后超出 int 32 位的取值范围了
 *
 * 导致 int 类型溢出的语句 result = result * 10 + temp;
 *
 * 所以在溢出之前要对溢出进行判断
 */
public class Solution07 {

    public static int reverse(int x) {
        int result = 0;
        // 当 x = 0 时，证明最后一位被处理完成，处理结束
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            // 要在可能会发生溢出的操作前，对溢出进行判断
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && pop > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE && pop < -8)) return 0;
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(-123 / 10);
        System.out.println(-123 % 10);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(-123));
    }
}