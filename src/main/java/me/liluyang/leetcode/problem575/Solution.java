package me.liluyang.leetcode.problem575;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/distribute-candies/
 * <p>
 * 575. Distribute Candies
 */
public class Solution {

    public static void main(String[] args) {
        int i = 1;
        int[] candies = {1,1,2,3};
        System.out.println(i++);
        System.out.println(++i);
        System.out.println(distributeCandies(candies));


    }

    /**
     * HashSet的解决办法，计算过程中涉及到了去重的解决办法，获得糖果的种类个数这一步骤
     * 非重复数据是Set这种数据结构的特性，非常关键
     * @param candies
     * @return
     */
    public static int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet();
        // 1.排序
        for (int i = 0; i < candies.length; i++) {
            set.add(candies[i]);
        }
        return set.size() > (candies.length / 2) ? (candies.length / 2) : set.size();
    }

    /**
     * 分糖果，一个弟弟，一个妹妹，返回妹妹最多可以获得的糖果的种类
     * 数组长度偶数，每个数字代表一个水果
     * 一人获得一半的糖果，妹妹优先获得更多的种类
     * 返回糖果总种类个数和糖果一半值中比较小的那个值
     *
     * @param candies
     * @return
     */
    public static int distributeCandies2(int[] candies) {
        int result = 0;
        // 1.排序
        Arrays.sort(candies);
        Arrays.toString(candies);
        System.out.println(candies);

        // 1,1,2,3
        // 2.排序，每种颜色水果，来一个，如果大于一般，返回一般，如果不够一般，返回这个数字
        for (int i = 0; i < candies.length - 1; i++) {
            if (candies[i] != candies[i + 1]) {
                result++;
            }
        }
        ++result;
        return result > (candies.length / 2) ? (candies.length / 2) : result;
    }
}
