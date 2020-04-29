package me.liluyang.leetcode;

/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (37.59%)
 * Total Accepted:    37.3K
 * Total Submissions: 98.9K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 
 * 
 * 说明:
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 
 */

class Solution28 {
    /**
     * 返回字符串最先出现的位置
     *
     * 解题思路：双指针
     *
     * 代码逻辑：
     *      1. 遍历 haystack 字符串。
     *      2. 如果 haystack 的当前字符和 needle 字符的第一个字符相同，则使用第二个指针遍历 needle 余下的字符是否和当前字符串对应相对位置的字符串相同
     *      3. 如果都相同，返回第一个相同字符的位置
     *      4.如果遍历结束没有对应的匹配结果，返回 -1
     *
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        char[] chars = haystack.toCharArray();
        char[] needles = needle.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == needles[0]) {
                int j = i;
                for (int k = 0; k < needles.length; k++) {
                    if (j < chars.length && chars[j] == needles[k]) {
                        j++;
                        continue;
                    } else {
                        break;
                    }
                }
                if ( j - i  == needles.length) return i;
            }
        }
        return -1;
    }
}

