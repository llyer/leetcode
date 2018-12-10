package me.liluyang.leetcode.problem014;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * 字符串数组的最长相同前缀
 *
 * 思路：先获取第一个字符串和第二个字符串的共同前缀，然后和第三个比较第四个比较等等
 *
 * 空间复杂度：O(1)，计算过程中使用的额外空间是恒定的，此例中只用了 prefix 一个额外变量
 * 时间复杂度：O(S)，变量 S 是输入字符数组中字符数组的个数
 *
 *
 */
public class Solution {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        String prefix = strs[0];
        //
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
//        String[] strings = {"dog","racecar","car"};
        // 输出空串
        System.out.println("dog".substring(0, 0));
        System.out.println(longestCommonPrefix(strings));
    }

    /**
     * 水平优先算法
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // 遍历第一个字符串的字符
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);

            // 遍历剩下的字符串
            for (int j = 1; j < strs.length; j ++) {
                // 如果当前字符串的长度等于第一个字符串的前 i 个，或者当前字符串的第 i 个字符串和第一个字符串不同
                if (i == strs[j].length() || strs[j].charAt(i) != c)

                    // 返回第一个字符串的前 i 个字符
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    /**
     * 思路没有问题，但是由于没有判断，后面的字符串的长度可能会比第一个字符串的长度短，导致 StringIndexOutOfBoundsException
     *
     * Accepted
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";

        // 遍历字符串，按顺序获取每个字符
        for (int i = 0; i < strs[0].length(); i++) {
            // 根据当前字符遍历剩余的所有字符串
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i) || strs[j].length() == i) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
