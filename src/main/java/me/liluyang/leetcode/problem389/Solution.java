package me.liluyang.leetcode.problem389;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/distribute-candies/
 * <p>
 * 575. Distribute Candies
 */
public class Solution {

    public static void main(String[] args) {
        int i = 1;
        int[] candies = {1,1,2,3};
        int[] ints1 = new int[100];
        // 数组的长度不能改变，容器 ArrayList 之类的 size 可以变
//        ints1.length = ints1.length-1;
        System.out.println(ints1.length);
        System.out.println(i++);
        System.out.println(++i);
        System.out.println(findTheDifference2("abc", "abcd"));
    }

    /**
     * 思路：使用 ASCII 中转计算，char字符转成ASCII数字，计算，再把ASCII数字转成 char 字符。
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        int sum = 0;
        for (char c: t.toCharArray()) {
            sum += c;
        }
        for (char c: s.toCharArray()) {
            sum -= c;
        }
        return (char)sum;
    }

    /**
     * 找不同，找出字符串 t 中比 s 多出来的一个字符
     * 思路：需要在遍历的时候删除元素，这在写代码的过程中好像是大忌
     *
     * 链表来存储数据，并且在比较时删除两个链表里面相同的元素，留下来的就是剩下的元素。链表，增删快一点，但是相对用 ASCII 还是慢了很多
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference2(String s, String t) {
        LinkedList<Character> chars = new LinkedList<>();
        LinkedList<Character> lists = new LinkedList();
        for (char c: s.toCharArray()) {
            chars.add(c);
        }
        for (char c: t.toCharArray()) {
            lists.add(c);
        }
        for (int i = 0; i < chars.size(); i++) {
            if (lists.contains(chars.get(i))) lists.remove(chars.get(i));
        }
        return lists.getFirst();
    }
}
