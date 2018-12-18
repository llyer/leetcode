package me.liluyang.leetcode.problem781;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/rabbits-in-forest/
 * <p>
 * 781. Rabbits in Forest
 * <p>
 * difficulty: Medium
 */
public class Solution {

    public static void main(String[] args) {
        int[] rabbits = {1, 1, 2};
        System.out.println(numRabbits(rabbits));
    }

    /**
     * 使用 HashMap 存储， key 是说有X中和自己想通的颜色的兔子中的X，value 是这么说的兔子的总个数
     *
     * 需要注意的点，如果有三个兔子说只有一个兔子和自己一样，那么至少存在四只兔子
     * @param answers
     * @return
     */
    public static int numRabbits(int[] answers) {
        if (answers.length == 0) return 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int answer: answers) {
            if (answer == 0) {
                count++;
            } else if (map.containsKey(answer)) {
                Integer num = map.get(answer);
                map.put(answer, ++num);
            } else {
                map.put(answer, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry: entries) {
            if (entry.getValue() % (entry.getKey() + 1) == 0) {
                count += ((entry.getValue() / (entry.getKey() + 1))) * (entry.getKey() + 1);
            } else {
                count += ((entry.getValue() / (entry.getKey() + 1) + 1)) * (entry.getKey() + 1);
            }
        }
        System.out.println(count);
        return count;
    }
}
