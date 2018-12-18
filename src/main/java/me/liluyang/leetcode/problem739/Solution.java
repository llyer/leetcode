package me.liluyang.leetcode.problem739;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * <p>
 * 739. Daily Temperatures 每日温度
 * <p>
 * difficulty: Medium
 */
public class Solution {

    public static void main(String[] args) {
        int[] next = new int[100];

        int[] pics = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(next[1]);
        System.out.println(Arrays.toString(dailyTemperatures(pics)));
    }

    /**
     * 输入的是每天温度的数组，输出的是每天最近一次温度上升所需要的天数
     * 每天的温度范围是 30 - 100
     * 如果没有上升的温度，计为 0
     * s
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        // 记录每个温度最新一次出现的坐标，每次到一个温度，只用比较这个数组中的大于当日温度的温度列表就可以了
        int[] next = new int[102]; // 设置 102，多出两个一个是因为没有用0坐标，一个是因为要和下一个比较
        // 结果数组，记录返回的 result
        int[] results = new int[T.length];
        // 倒序循环
        for (int i = T.length - 1; i >= 0; i--) {
            // 1.计算result，需要根据上面的坐标数组来计算，由于数据的计算是倒序的循环，所以循环到当前元素时，后续由多个相同的温度数据，我们也只需要存储最近的就可以了
            // 50 度，比较 51 52 53 度的坐标， i是当前日期， T[i] = j 代表是当前日期的温度，next[j] 是当前最近温度的最近一次出现的坐标
            int minPicIndex = next[T[i] + 1]; // 51 度的坐标
            for (int j = T[i] + 1; j < next.length; j++) {
                // 如果小于坐标存在，0是默认值，所以比较时，忽略零
                if (minPicIndex == 0 && next[j] != 0) minPicIndex = next[j];
                if (minPicIndex > next[j] && next[j] != 0) minPicIndex = next[j];
            }
            // minPic 为最低温度坐标， 默认值是零，计算出需要的天数
            results[i] = minPicIndex == 0 ? 0 : minPicIndex - i;
            // 2.记录当前温度坐标数组中
            next[T[i]] = i;
        }
        return results;
    }
}
