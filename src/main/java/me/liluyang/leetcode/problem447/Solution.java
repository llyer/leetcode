package me.liluyang.leetcode.problem447;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
    }

    /**
     * 447 找出存在的回旋镖数量
     *
     * 数学知识：排列组合，高中二年级
     *
     * 取任意一个点，将其他所有点到这个点的距离，并且按照距离和个数的键值对存储
     *
     *
     *
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        Integer result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distances = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int distance = x * x + y * y;
                distances.put(distance, distances.getOrDefault(distance, 0) + 1);
            }
            for (int item: distances.values()) {
                result += item * (item - 1);
            }
        }
        return result;
    }

}