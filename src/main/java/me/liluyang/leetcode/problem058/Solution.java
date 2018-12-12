package me.liluyang.leetcode.problem058;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * <p>
 * 最后一个单词的长度
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord("Hello World abandon"));
    }

    public static int lengthOfLastWord(String s) {
        /**
         * 切分之后数组的长度可能会为零
         */
        String[] split = s.split(" ");
        if (split.length > 0) return split[split.length - 1].length();
        return 0;
    }
}
