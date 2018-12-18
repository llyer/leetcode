package me.liluyang.leetcode.problem771;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 * <p>
 * 771. Jewels and Stones 宝石和石头
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(" ");

        int[] dollars = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
    }

    /**
     * 这道题在分类上属于 hashTable，但是不用也可以搞，用 HashTable 的思路是先遍历 stones，key 是石头，value 是这种石头的个数
     * 宝石和石头
     * @param J 宝石，每个字符代表一个宝石
     * @param S 石头集合手上的石头
     * @return 拥有宝石的数量
     */
    public int numJewelsInStones(String J, String S) {
        char[] stones = S.toCharArray();
        char[] chars = J.toCharArray();
        int count = 0;

        // 设置容器集合
        Set jewels = new HashSet<Character>();
        for (int i = 0; i < chars.length; i++) {
            jewels.add(chars[i]);
        }
        // 计算
        for (int i = 0; i < stones.length; i++) {
            if (jewels.contains(stones[i])) {
                count++;
            }
        }
        return count;
    }
}
