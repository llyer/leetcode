package me.liluyang.leetcode.problem038;

import java.util.HashMap;

public class Solution {

    /**
     * 报数
     *
     * 解决思路：
     *
     * 核心部分是将当前的数字组合念出来，可以通过一遍循环，来遍历数字，例如 1211 念出来就是 一个一，一个二，两个一，得到的结果是 111221
     *
     *
     * 然后题目中给出的 n 就是循环获取数字，上一轮循环的结果，作为下一轮的参数继续循环
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String start = "1";
        for (int i = 0; i < n - 1; i++) {
            start = foo(start);
        }
        return start;
    }

    public String foo(String start) {
        HashMap<Character, Integer> map = new HashMap();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < start.toCharArray().length; j++) {
            int count = map.getOrDefault(start.charAt(j), 0) + 1;
            map.put(start.charAt(j), count);
            if (j + 1 < start.toCharArray().length) {
                // 取数据，并且重置源数据
                if (start.charAt(j) != start.charAt(j + 1)){
                    sb.append(map.get(start.charAt(j)));
                    sb.append(start.charAt(j));
                    map.remove(start.charAt(j));
                }
            }
        }
        sb.append(map.get(start.charAt(start.toCharArray().length - 1)));
        sb.append(start.charAt(start.toCharArray().length - 1));
        return sb.toString();
    }

}
