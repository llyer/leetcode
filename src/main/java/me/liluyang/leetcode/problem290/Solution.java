package me.liluyang.leetcode.problem290;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 * <p>
 * 290. Word Pattern
 */
public class Solution {

    public static void main(String[] args) {
        int i = 1;
        int[] candies = {1, 1, 2, 3};
        int[] ints1 = new int[100];
        // 数组的长度不能改变，容器 ArrayList 之类的 size 可以变
//        ints1.length = ints1.length-1;
        System.out.println(ints1.length);
        System.out.println(i++);
        System.out.println(++i);
//        System.out.println("为什么两个 127 不相等" + (new Integer(127) == new Integer(127)));
//        System.out.println("为什么两个 128 不相等" + (new Integer(128) == new Integer(128)));
//        System.out.println(wordPattern3("aa", "cat cat"));

        System.out.println(wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd", "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"));
    }

    /**
     * 单词模式
     * <p>
     * 字符和单词的相对位置关系要完全相同。
     * 每次循环时，当前位置关系是一定匹配的，因为是一遍循环，下标 i 肯定相同，这事需要确认这对字符上一次出现的相对位置关系也是相同的。
     * <p>
     * 如果任何一对字符和单词的相对关系不同，那就比较失败了
     * <p>
     * 所以比较时，首先将 pattern 转换为字符数组，str 转换为单词数组
     * <p>
     * 需要一对变量来存储比较过程中当前比较的一对字符上一次出现时的位置关系。
     *
     * 用 Integer 就都用，不用就都不用，for循环用 int ，接受参数用 Integer 就会报错 128 ！= 128
     *
     * https://leetcode.com/problems/word-pattern/discuss/206240/why-128-!-128 错误代码
     *
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) return false;
        char[] chars = pattern.toCharArray();
        String[] strings = str.split(" ");
        if (chars.length != strings.length) return false;

        // 上次出现的位置
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<String, Integer> stringMap = new HashMap<>();
        for (Integer i = 0; i < chars.length; i++) {
            Integer patternIndex = patternMap.getOrDefault(chars[i], i);
            Integer strIndex = stringMap.getOrDefault(strings[i], i);
            if (strIndex != patternIndex) {
                System.out.println(patternIndex + "!=" + strIndex);
                return false;
            }
            // 记录当前字符和单词的位置
            patternMap.put(chars[i], i);
            stringMap.put(strings[i], i);
        }
        return true;
    }

    public static boolean wordPattern2(String pattern, String str) {
        if (pattern == null || str == null) return false;
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) return false;
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<String, Integer> strMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            int strIndex = strMap.getOrDefault(strArray[i], i);
            int patternIndex = patternMap.getOrDefault(pattern.charAt(i), i);
            if (strIndex != patternIndex) return false;
            strMap.put(strArray[i], i);
            patternMap.put(pattern.charAt(i), i);
        }
        return true;
    }


}
