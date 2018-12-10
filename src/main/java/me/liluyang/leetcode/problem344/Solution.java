package me.liluyang.leetcode.problem344;

public class Solution {

    /**
     * 字符串反转
     *
     * 字符串转字符数组，遍历Push到新的字符串
     * @param s
     * @return
     */
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        return sb.toString();
    }


    /**
     * 字符串反转
     *
     * StringBuilder 和 StringBuffer 性能对比
     * @param s
     * @return
     */
    public String reverseString2(String s) {
        StringBuffer sb = new StringBuffer();
        char[] charArray = s.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        return sb.toString();
    }
}