package me.liluyang.leetcode.problem125;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * <p>
 * 验证回文字符串，忽略小写字母
 *
 * Input: "A man, a plan, a canal: Panama"
 * Input: "race a car"
 *
 * 思路：过滤出字符和数字然后转成小写字母，然后执行双指针方法判断
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(" ");
    }

    /**
     * 双指针问题
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        // 单线程
        StringBuilder sb = new StringBuilder();
        // 过滤字符
        for(Character ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
        char[] chars = sb.toString().toLowerCase().toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 -i]) {
                return false;
            }
        }
        return true;
    }
}
