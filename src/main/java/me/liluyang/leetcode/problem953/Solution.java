package me.liluyang.leetcode.problem953;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class Solution {
    public static void main(String[] args) {
//        String[] words = {"hello","leetcode"};
        String[] words = {"ubg","kwh"};
        // ["ubg","kwh"] "qcipyamwvdjtesbghlorufnkzx"

//        System.out.println("abc".charAt(4));
        System.out.println(isAlienSorted(words, "qcipyamwvdjtesbghlorufnkzx"));
    }

    /**
     * 验证外星语词典
     *
     * 1.根据外星人的字母表 order 计算出每一个字符在外星语中的顺序，使用一个 index[26] 的数组，分别是 26 个字母在外星的顺序（权重）
     *
     * 2.遍历单词，依次比较各个单词的顺序，如果存在单词不符合顺序就返回 false
     *
     * 2.1 单词比较的业务逻辑是找到第一个不同的字母然后按照外星文的顺序进行顺序比较
     *
     * 3.存在不符合的返回 false
     *
     * 4.循环结束都符合，返回 true
     *
     * @param words
     * @param order
     * @return
     */
    public static boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        // 记录每一个单词在外星的位置权重信息
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        // 比较所有单词
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // 循环比较两个单词的字母
            for (int j = 0; j < word1.length(); j++) {
                Character char1 = word1.charAt(j);
                Character char2;
                if (word2.length() > j) {
                    char2 = word2.charAt(j);
                } else {
                    char2 = null;
                }
                // 因为 第一个单词在，第二个单词不在，第一个大，返回错误
                if (char2 == null) return false;
                if (char1 == char2) {
                    continue;
                } else if (index[char1 - 'a'] > index[char2 - 'a']) {
                    return false;
                } else if (index[char1 - 'a'] < index[char2 - 'a']) {
                    break;
                }
            }
            // 如果第一个单词循环结束后，第二个单词还有，那么不用管，第二个单词的顺序大，继续循环下一个单词就可以了
        }
        return true;
    }
}