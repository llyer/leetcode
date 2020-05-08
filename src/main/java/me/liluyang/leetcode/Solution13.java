package me.liluyang.leetcode;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * <p>
 * 罗马数字转阿拉伯数字
 *
 * 如果是以下三种情况就是两个数字组成一个数字，其他情况就是一个数字表示一个数字，正常循环一遍就可以
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 */
public class Solution13 {

    public static int romanToInt(String s) {
        int result = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I') {
                if ((i + 1) < chars.length && chars[i + 1] == 'V') {
                    result += 4;
                    i++;
                    continue;
                } else if ((i + 1) < chars.length && chars[i + 1] == 'X') {
                    result += 9;
                    i++;
                    continue;
                }
                result += 1;
            }

            if (chars[i] == 'X') {
                if ((i + 1) < chars.length && chars[i + 1] == 'L') {
                    result += 40;
                    i++;
                    continue;
                } else if ((i + 1) < chars.length && chars[i + 1] == 'C') {
                    result += 90;
                    i++;
                    continue;
                }
                result += 10;
            }

            if (chars[i] == 'C') {
                if ((i + 1) < chars.length && chars[i + 1] == 'D') {
                    result += 400;
                    i++;
                    continue;
                } else if ((i + 1) < chars.length && chars[i + 1] == 'M') {
                    result += 900;
                    i++;
                    continue;
                }
                result += 100;
            }

            if (chars[i] == 'V') result += 5;
            if (chars[i] == 'L') result += 50;
            if (chars[i] == 'D') result += 500;
            if (chars[i] == 'M') result += 1000;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}